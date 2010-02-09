package com.piragua.buildinfo

import grails.util.Environment

class StatusPageFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    void testBuildInfoPage() {
        get('/buildInfo')
        assertStatus 200

        // this label is overridden in messages.properties
        assertContentContains "Source Control Revision #"
        assertContentContains "Build Date"

        assertContentContains "Grails Environment"
        assertContentContains Environment.current.toString()

        assertContentContains "Grails version"
        assertContentContains "JVM version"

    }
}
