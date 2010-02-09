<%@ page import="grails.util.Environment" %>
<h1><g:message code="runtime.app.status"/></h1>

<table>
    <tr>
        <td><g:message code="grails.env"/></td><td>${Environment.current}</td>
    </tr>
    <tr>
        <td><g:message code="app.version"/></td><td><g:meta name="app.version"/></td>
    </tr>
    <tr>
        <td><g:message code="app.grails.version"/></td><td><g:meta name="app.grails.version"/></td>
    </tr>
    <tr>
        <td><g:message code="java.version"/></td><td>${System.getProperty('java.version')}</td>
    </tr>
</table>
