
<%@ page import="org.duoc.rentacar.Cliente" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'cliente.label', default: 'Cliente')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-cliente" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-cliente" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="rut" title="${message(code: 'cliente.rut.label', default: 'Rut')}" />
                                                
                                                <g:sortableColumn property="nombre" title="${message(code: 'cliente.nombre.label', default: 'Nombre')}" />
					
						<g:sortableColumn property="apellidoPaterno" title="${message(code: 'cliente.apellidoPaterno.label', default: 'Apellido Paterno')}" />
					
                                                <g:sortableColumn property="apellidoMaterno" title="${message(code: 'cliente.apellidoMaterno.label', default: 'Apellido Materno')}" />
					
						<g:sortableColumn property="fechaNacimiento" title="${message(code: 'cliente.fechaNacimiento.label', default: 'Fecha Nacimiento')}" />
					
						<g:sortableColumn property="email" title="${message(code: 'cliente.email.label', default: 'Email')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${clienteInstanceList}" status="i" var="clienteInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${clienteInstance.id}">${fieldValue(bean: clienteInstance, field: "rut")}</g:link></td>
					
						<td>${fieldValue(bean: clienteInstance, field: "nombre")}</td>
                                                
                                                <td>${fieldValue(bean: clienteInstance, field: "apellidoPaterno")}</td>
					
                                                <td>${fieldValue(bean: clienteInstance, field: "apellidoMaterno")}</td>
					
						<td><g:formatDate date="${clienteInstance.fechaNacimiento}" /></td>
					
						<td>${fieldValue(bean: clienteInstance, field: "email")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${clienteInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
