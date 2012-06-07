
<%@ page import="org.duoc.rentacar.Comuna" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'comuna.label', default: 'Comuna')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-comuna" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-comuna" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nombre" title="${message(code: 'comuna.nombre.label', default: 'Nombre')}" />
					
						<th><g:message code="comuna.provincia.label" default="Provincia" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${comunaInstanceList}" status="i" var="comunaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${comunaInstance.id}">${fieldValue(bean: comunaInstance, field: "nombre")}</g:link></td>
					
						<td>${fieldValue(bean: comunaInstance, field: "provincia")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${comunaInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
