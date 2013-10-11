package grails.plugin.buildinfo

import grails.test.ControllerUnitTestCase
import org.codehaus.groovy.grails.commons.ConfigurationHolder

class BuildInfoControllerTests extends ControllerUnitTestCase {

    void testIndex(){
        controller.index()
        assertEquals 'index', renderArgs.view

        assertEquals controller.buildInfoProperties, renderArgs.model.buildInfoProperties
    }


    void testIndex_overrideDefaults(){
        mockConfig """
            buildInfo.properties.exclude = ['scm.version']
            buildInfo.properties.add = ['custom.property']
        """

        controller.index()
        assertEquals 'index', renderArgs.view

        def expectedProperties = controller.buildInfoProperties - 'scm.version' 
        expectedProperties = expectedProperties + 'custom.property'

        assertEquals expectedProperties, renderArgs.model.buildInfoProperties
    }


}