# Calculator  [![Build Status](https://travisci.octodemoapps.com/OctoCheese/Calculator.svg?token=wYtKbMf727cmJBBMbSRW&branch=master)](https://travisci.octodemoapps.com/OctoCheese/Calculator)

This is the ultimate crazy scientific calculator (limited to 4 operations) without any ~~Bugs~~


# Deploy
## Without required context
```
curl -k -H "Authorization: token $GHE_PERSONAL_ACCESS_TOKEN" -d '{"ref": "mybranch", "environment" : "Test Lab", "description" : "Ready for user acceptance"}' https://octodemo.com/api/v3/repos/OctoCheese/Calculator/deployments
```

## With required context
```
curl -k -H "Authorization: token $GHE_PERSONAL_ACCESS_TOKEN" -d '{"ref": "mybranch", "environment" : "Test Lab", "description" : "Ready for user acceptance", "required_contexts": ["continuous-integration/jenkins/build"]}' https://octodemo.com/api/v3/repos/OctoCheese/Calculator/deployments
```

Output 

```
{
  "url": "https://octodemo.com/api/v3/repos/OctoCheese/Calculator/deployments/2142",
  "id": 2142,
  "sha": "7b991d1c0c1e23eb362f07bfe9b232b5929efb59",
  "ref": "status",
  "task": "deploy",
  "payload": {

  },
  "environment": "Test Lab",
  "description": "Ready for user acceptance",
  "creator": {
  ..
  },
  ...
}
```

Now retrieve the deployment Id to send feedback about the deployment 

## Set status

```
curl -k -H "Authorization: token $GHE_PERSONAL_ACCESS_TOKEN"  -H "accept: application/vnd.github.ant-man-preview+json" -d '{"state": "pending", "description": "Deploying to Test Lab...", "log_url": "http://deploysystem.com/logs"}' https://octodemo.com/api/v3/repos/OctoCheese/Calculator/deployments/2142/statuses
```

## Completed
- For non-transient environments 

```
curl -k -H "Authorization: token $GHE_PERSONAL_ACCESS_TOKEN" -H "accept: application/vnd.github.ant-man-preview+json" -d '{"state": "success", "description": "Deploying to Test Lab...", "log_url": "http://deploysystem.com/logs", "environment_url": "http://patch.myapp.com"}' https://octodemo.com/api/v3/repos/OctoCheese/Calculator/deployments/2142/statuses
```

- For transient environments 

```
curl -k -H "Authorization: token $GHE_PERSONAL_ACCESS_TOKEN" -H "accept: application/vnd.github.ant-man-preview+json" -d '{"state": "success", "description": "Deploying to Test Lab...", "log_url": "http://deploysystem.com/logs", "environment_url": "http://patch.myapp.com", "auto_inactive": false}' https://octodemo.com/api/v3/repos/OctoCheese/Calculator/deployments/2142/statuses
```


# Content
- Issues 
- Milestones 
- [Contributing guidelines](https://octodemo.com/OctoCheese/Calculator/blob/master/CONTRIBUTING.md) with **issue templates**
- Releases
- *Badges*
- Deployements
- Emoticons :+1: :tada: :grin:
- [GitHub Pages site]( https://octodemo.com/pages/OctoCheese/Calculator)

You can also have a look at code samples
```java
public void methodName(String param1, int param2) {
  String value = doSomething(param1, param2);
}
````

And create arrays : 

|Col 1|Col 2|Col 3|
|-----|-----|-----|
|Val 1|Val 2|Val 3|
|Val 1|Val 2|Val 3|
|Val 1|Val 2|Val 3|
  
  
[Show me the bugs](https://octodemo.com/OctoCheese/Calculator/issues?q=is%3Aopen+is%3Aissue+label%3A%22bug+-+severity+1%22)
