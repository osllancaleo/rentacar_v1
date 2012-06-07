
<%@ page import="org.duoc.rentacar.EstadoVehiculo" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'estadoVehiculo.label', default: 'EstadoVehiculo')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-estadoVehiculo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-estadoVehiculo" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nombre" title="${message(code: 'estadoVehiculo.nombre.label', default: 'Nombre')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${estadoVehiculoInstanceList}" status="i" var="estadoVehiculoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${estadoVehiculoInstance.id}">${fieldValue(bean: estadoVehiculoInstance, field: "nombre")}</g:link></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${estadoVehiculoInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
