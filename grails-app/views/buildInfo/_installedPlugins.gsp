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
