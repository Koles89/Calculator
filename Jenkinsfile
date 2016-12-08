#!groovy

node {
    // pull request or feature branch
    if  (env.BRANCH_NAME != 'master') {
        checkout()
        build()
        unitTest()
        preview()
    } // master branch / production
    else {
        checkout()
        build()
        allTests()
        preProduction()
        manualPromotion()
        production()
    }
}

def checkout () {
    stage 'Checkout code'
    setBuildStatus 'continuous-integration/jenkins/checkout', 'Checking out...', 'PENDING'
    checkout scm
    setBuildStatus 'continuous-integration/jenkins/checkout', 'Checking out completed', 'SUCCESS'
}

def build () {
    stage 'Build'
    // cache maven artifacts
    shareM2 '/tmp/m2repo'
    mvn 'clean install -DskipTests=true -Dmaven.javadoc.skip=true -Dcheckstyle.skip=true -B -V'
}


def unitTest() {
    stage 'Unit tests'
    mvn 'test -B -Dmaven.javadoc.skip=true -Dcheckstyle.skip=true'
    step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
    if (currentBuild.result == "UNSTABLE") {
        sh "exit 1"
    }
}

def allTests() {
    stage 'All tests'
    // don't skip anything
    mvn 'test -B'
    step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
    if (currentBuild.result == "UNSTABLE") {
        // input "Unit tests are failing, proceed?"
        sh "exit 1"
    }
}

def preview() {
    stage name: 'Deploy to Preview env', concurrency: 1
}

def preProduction() {
    stage name: 'Deploy to Pre-Production', concurrency: 1
}

def manualPromotion() {
  stage 'Manual Promotion'
  input message: "Does Pre-Production look good?"
}

def production() {
    stage name: 'Deploy to Production', concurrency: 1
    step([$class: 'ArtifactArchiver', artifacts: '**/target/*.jar', fingerprint: true])
}

def mvn(args) {
    // point to settings.xml with cached .m2 directory and proceed in case of test failures
    sh "${tool 'Maven 3.x'}/bin/mvn -s settings.xml ${args} -Dmaven.test.failure.ignore"
}

def shareM2(file) {
    // Set up a shared Maven repo so we don't need to download all dependencies on every build.
    writeFile file: 'settings.xml',
    text: "<settings><localRepository>${file}</localRepository></settings>"
}

void setBuildStatus(String context, String message, String state) {
  step([
      $class: "GitHubCommitStatusSetter",
      contextSource: [$class: "ManuallyEnteredCommitContextSource", context: context],
      errorHandlers: [[$class: "ChangingBuildStatusErrorHandler", result: "UNSTABLE"]],
      statusResultSource: [ $class: "ConditionalStatusResultSource", results: [[$class: "AnyBuildResult", message: message, state: state]] ]
  ]);
}
