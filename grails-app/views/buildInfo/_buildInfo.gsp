<h1><g:message code="plugin.title"/> </h1>
<table>

    <g:each in="${buildInfoProperties}" var="prop">
        <g:if test="${g.meta(name:prop)}">
            <tr>
                <td><g:message code="${prop}"/></td><td><g:meta name="${prop}"/></td>
            </tr>
        </g:if>
    </g:each>

</table>
