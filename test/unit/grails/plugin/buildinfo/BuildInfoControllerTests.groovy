package grails.plugin.buildinfo

import grails.test.ControllerUnitTestCase

class BuildInfoControllerTests extends ControllerUnitTestCase {
    def grailsApplication = new org.codehaus.groovy.grails.commons.DefaultGrailsApplication()

    protected void setUp() {
        super.setUp()
        controller.grailsApplication = grailsApplication
        ['build.date', 'scm.version', 'environment.BUILD_NUMBER', 'environment.BUILD_ID', 'environment.BUILD_TAG', 'environment.GIT_BRANCH', 'environment.GIT_COMMIT'].each {
            controller.grailsApplication.metadata[it] = 'MOCK'
        }
    }

    void testIndex(){
        controller.index()
        assertEquals 'index', renderArgs.view

        assertEquals controller.buildInfoProperties.size(), renderArgs.model.buildInfoProperties.size()
    }

    void testIndex_overrideDefaults(){
        mockConfig """
            buildInfo.properties.exclude = ['scm.version']
            buildInfo.properties.add = ['custom.property']
        """
        controller.grailsApplication.metadata['custom.property'] = 'MOCK'
        controller.index()
        assertEquals 'index', renderArgs.view

        def expectedProperties = controller.buildInfoProperties - 'scm.version'
        expectedProperties = expectedProperties + 'custom.property'

        assertEquals expectedProperties.size(), renderArgs.model.buildInfoProperties.size()
    }

}
