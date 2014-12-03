<h1>Installed Plugins</h1>

<table>
    <g:each status="i" var="plugin" in="${installedPlugins}">
        <tr>
            <td>${plugin.name}</td><td>${plugin.version}</td>
        </tr>
    </g:each>
</table>
