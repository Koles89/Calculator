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
        production()
    }
}

def checkout () {
    stage('Checkout code') {
//        setBuildStatus 'continuous-integration/jenkins/checkout', 'Checking out...', 'PENDING'
        checkout scm
    }
}

def build () {
    stage('Build') {
        setBuildStatus 'continuous-integration/jenkins/build', 'Building...', 'PENDING'
        // cache maven artifacts
        shareM2 '/tmp/m2repo'
        mvn 'clean install -DskipTests=true -Dmaven.javadoc.skip=true -Dcheckstyle.skip=true -B -V'
 
        if (currentBuild.result == "UNSTABLE") {
            setBuildStatus 'continuous-integration/jenkins/build', 'Building failed', 'FAILURE'
        } else {
            setBuildStatus 'continuous-integration/jenkins/build', 'Building completed', 'SUCCESS'
        }
    }
}


def unitTest() {
    stage('Unit tests') {
        setBuildStatus 'continuous-integration/jenkins/unit-tests', 'Unit testing...', 'PENDING'
        mvn 'test -B -Dmaven.javadoc.skip=true -Dcheckstyle.skip=true'
        step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
        if (currentBuild.result == "UNSTABLE") {
            setBuildStatus 'continuous-integration/jenkins/unit-tests', 'Unit testing failed', 'FAILURE'
        } else {
            setBuildStatus 'continuous-integration/jenkins/unit-tests', 'Unit testing completed', 'SUCCESS'
        }
    }
}

def allTests() {
    stage('All tests') {
        setBuildStatus 'continuous-integration/jenkins/all-tests', 'Running all tests...', 'PENDING'
        // don't skip anything
        mvn 'test -B'
        step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
        if (currentBuild.result == "UNSTABLE") {
            setBuildStatus 'continuous-integration/jenkins/all-tests', 'Testing failed', 'FAILURE'
            // input "Unit tests are failing, proceed?"
        } else {
            setBuildStatus 'continuous-integration/jenkins/all-tests', 'Testing completed', 'SUCCESS'
        }
    }
}

def preview() {
    stage name: 'Deploy to Preview env', concurrency: 1
}

def preProduction() {
    stage name: 'Deploy to Pre-Production', concurrency: 1
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
      reposSource: [$class: "ManuallyEnteredRepositorySource", url: "https://octodemo.com/OctoCheese/Calculator"],
      errorHandlers: [[$class: "ChangingBuildStatusErrorHandler", result: "UNSTABLE"]],
      statusResultSource: [ $class: "ConditionalStatusResultSource", results: [[$class: "AnyBuildResult", message: message, state: state]] ]
  ]);
}
