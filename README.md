# Calculator [![Build Status](https://travis.octodemo.com/OctoCheese/Calculator.svg?token=4JfJ19izssZfCpxkrhWU&branch=master)](https://travis.octodemo.com/OctoCheese/Calculator)
This is the ultimate crazy scientific calculator (limited to 4 operations) without any ~~Bugs~~


# Deploy
## No status
curl -k -H "Authorization: token $GHE_PERSONAL_ACCESS_TOKEN" -d '{"ref": "patch", "environment" : "Test Lab", "description" : "Ready for user acceptance"}' https://octodemo.com/api/v3/repos/OctoCheese/Calculator/deployments

## With required context
curl -k -H "Authorization: token $GHE_PERSONAL_ACCESS_TOKEN" -d '{"ref": "patch", "environment" : "Test Lab", "description" : "Ready for user acceptance", "required_contexts": "["continuous-integration/jenkins/build"]"}' https://octodemo.com/api/v3/repos/OctoCheese/Calculator/deployments

## Set status
curl -k -H "Authorization: token $GHE_PERSONAL_ACCESS_TOKEN" -d '{"state": "pending", "description": "Deploying to Test Lab...", "target_url": "http://patch.myapp.com"}' https://octodemo.com/api/v3/repos/OctoCheese/Calculator/deployments/565/statuses


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
