<%@ page import="grails.util.Environment" %>
<h1>Runtime Application Status</h1>

<table>
    <tr>
        <td>Grails Environment</td><td>${Environment.current}</td>
    </tr>
    <tr>
        <td>App version</td><td><g:meta name="app.version"/></td>
    </tr>
    <tr>
        <td>Grails version</td><td><g:meta name="app.grails.version"/></td>
    </tr>
    <tr>
        <td>Jvm version</td><td>${System.getProperty('java.version')}</td>
    </tr>
</table>
