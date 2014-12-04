<h1><g:message code="plugin.title"/> </h1>
<table>

    <g:each in="${buildInfoProperties}" var="key,value">
            <tr>
                <td><g:message code="${key}"/></td><td>${value}</td>
            </tr>
    </g:each>

</table>
