## Overview

Provides a controller/view that display basic information about the war file including the

- date/time the war file was built
- Source Control Revision Number (Git and Subversion)
- application version number
- grails version
- grails environment (currently running, not necessarily the environment used to build the war file)
- plugins installed (and which version)

If Hudson/Jenkins is used to build the war file the following Hudson environment variables are also displayed:

- BUILD_NUMBER
- BUILD_ID
- BUILD_TAG
- SVN_REVISION
- GIT_COMMIT
- GIT_BRANCH

## Security

Note that the plugin does not apply any security restrictions to the BuildInfo controller - __make sure to restrict access to this page__ if you do not want the information to be publicly available.

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
