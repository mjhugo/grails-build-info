# Overview

Provides a controller/view that display basic information about the war file including the

- date/time the war file was built
- application version number
- grails version
- grails environment (currently running, not necessarily the environment used to build the war file)
- plugins installed (and which version)

If Hudson is used to build the war file the following Hudson environment variables are also displayed:

- BUILD_NUMBER
- BUILD_ID
- BUILD_TAG
- SVN_REVISION

# Security

Note that the plugin does not apply any security restrictions to the BuildInfo controller - __make sure to restrict access to this page__ if you do not want the information to be publicly available.