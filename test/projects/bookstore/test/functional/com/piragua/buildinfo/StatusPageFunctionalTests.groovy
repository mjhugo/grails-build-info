package com.piragua.buildinfo

import grails.util.Environment

class StatusPageFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    void testBuildInfoPage() {
        get('/buildInfo')
        assertStatus 200

        // this label is overridden in messages.properties
        assertContentContains "Application Version"

        assertContentContains "Grails version"
        assertContentContains Environment.current.toString()
        assertContentContains "JVM version"

    }
}
