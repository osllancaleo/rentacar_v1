
<%@ page import="org.duoc.rentacar.Vehiculo" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'vehiculo.label', default: 'Vehiculo')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-vehiculo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-vehiculo" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="patente" title="${message(code: 'vehiculo.patente.label', default: 'Patente')}" />
					
						<g:sortableColumn property="anio" title="${message(code: 'vehiculo.anio.label', default: 'Anio')}" />
					
						<g:sortableColumn property="valorDia" title="${message(code: 'vehiculo.valorDia.label', default: 'Valor Dia')}" />
					
						<g:sortableColumn property="valorHora" title="${message(code: 'vehiculo.valorHora.label', default: 'Valor Hora')}" />
					
						<g:sortableColumn property="rendimiento" title="${message(code: 'vehiculo.rendimiento.label', default: 'Rendimiento')}" />
					
						<g:sortableColumn property="cantidadPasajero" title="${message(code: 'vehiculo.cantidadPasajero.label', default: 'Cantidad Pasajero')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${vehiculoInstanceList}" status="i" var="vehiculoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${vehiculoInstance.id}">${fieldValue(bean: vehiculoInstance, field: "patente")}</g:link></td>
					
						<td>${fieldValue(bean: vehiculoInstance, field: "anio")}</td>
					
						<td>${fieldValue(bean: vehiculoInstance, field: "valorDia")}</td>
					
						<td>${fieldValue(bean: vehiculoInstance, field: "valorHora")}</td>
					
						<td>${fieldValue(bean: vehiculoInstance, field: "rendimiento")}</td>
					
						<td>${fieldValue(bean: vehiculoInstance, field: "cantidadPasajero")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${vehiculoInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
