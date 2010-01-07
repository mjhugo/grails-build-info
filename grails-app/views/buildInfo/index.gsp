<html>
<head>
    <title>Build Info</title>
    <style type="text/css">
    h1 {
        color: #48802c;
        font-weight: normal;
        font-size: 20px;
        margin: .8em 0 .3em 0;
    }

    table {
        border: 1px solid #ccc;
        font-size: 14px;
    }

    tr {
        border: 0;
    }

    td, th {
        padding: 5px 6px;
        text-align: left;
        vertical-align: top;
    }

    </style>

</head>
<body>
<div id="pageBody">
    <h1>Build Info</h1>
    <table>
        <tr>
            <td>Build Date</td><td><g:meta name="build.date"/></td>
        </tr>
        <tr>
            <td>Source Control Revision #</td><td><g:meta name="scm.version"/></td>
        </tr>
        <g:if test="${g.meta(name:'build.number')}">
            <tr>
                <td>Build #</td><td><g:meta name="build.number"/></td>
            </tr>
        </g:if>
        <g:if test="${g.meta(name:'build.number')}">
            <tr>
                <td>Build ID</td><td><g:meta name="build.id"/></td>
            </tr>
        </g:if>
        <g:if test="${g.meta(name:'build.number')}">
            <tr>
                <td>Build Tag</td><td><g:meta name="build.tag"/></td>
            </tr>
        </g:if>
    </table>
    <h1>Runtime Application Status</h1>
    <table>
        <tr>
            <td>Grails Environment</td><td>${System.getProperty('grails.env')}</td>
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
    <h1>Installed Plugins</h1>
    <table>
        <g:set var="pluginManager"
                value="${applicationContext.getBean('pluginManager')}"></g:set>

        <g:each status="i" var="plugin" in="${pluginManager.allPlugins.sort({it.name.toUpperCase()})}">
            <tr>
                <td>${plugin.name}</td><td>${plugin.version}</td>
            </tr>
        </g:each>

    </table>
</div>
</body>
</html>