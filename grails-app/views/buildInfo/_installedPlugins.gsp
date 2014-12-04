<h1>Installed Plugins</h1>

<table>
    <g:each status="i" var="key, value" in="${installedPlugins}">
        <tr>
            <td>${key}</td><td>${value}</td>
        </tr>
    </g:each>
</table>
