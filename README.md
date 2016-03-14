## Overview

Provides a controller(BuildInfoController)/view that displays basic information about the war file including:

- date/time the war file was built
- Source Control Revision Number (Git and Subversion)
- application version number
- grails version
- grails environment (currently running, not necessarily the environment used to build the war file)
- plugins installed (and which version)

The information can be viewed by opening index action of the controller i.e. www.your-app.com/buildInfo

Also please note that build information(i.e. date/time the war file was built and SCM version number) will be available only when you are building the application by creating `war` file and deploying it. It will not be available when you are building it through `grails run-app`.

If Hudson/Jenkins is used to build the war file the following Hudson environment variables are also displayed:

- BUILD_NUMBER
- BUILD_ID
- BUILD_TAG
- SVN_REVISION
- GIT_COMMIT
- GIT_BRANCH

## Security

Note that the plugin does not apply any security restrictions to the BuildInfo controller - __make sure to restrict access to this page__ if you do not want the information to be publicly available.

It can be easily restricted if you are using Spring Security. All that is needed, is to add static rules in Config.groovy.
Here is the sample code to ensure that the url can be accessible only by users who have 'ADMIN' role:
`grails.plugin.springsecurity.controllerAnnotations.staticRules = [
        '/buildInfo/**'       : ['hasRole("ADMIN")'],
]`


## Changelog

### 1.2.5

* Package name changed to grails.plugin.buildinfo. See issue #7

### 1.2.4

* Subversion 1.7 support

### 1.2.3

### 1.2.2

### 1.2.1

### 1.1

### 1.0
