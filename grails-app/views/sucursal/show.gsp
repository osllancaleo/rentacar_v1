
<%@ page import="org.duoc.rentacar.Sucursal" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'sucursal.label', default: 'Sucursal')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-sucursal" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-sucursal" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list sucursal">
			
				<g:if test="${sucursalInstance?.nombre}">
				<li class="fieldcontain">
					<span id="nombre-label" class="property-label"><g:message code="sucursal.nombre.label" default="Nombre" /></span>
					
						<span class="property-value" aria-labelledby="nombre-label"><g:fieldValue bean="${sucursalInstance}" field="nombre"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${sucursalInstance?.direccion}">
				<li class="fieldcontain">
					<span id="direccion-label" class="property-label"><g:message code="sucursal.direccion.label" default="Direccion" /></span>
					
						<span class="property-value" aria-labelledby="direccion-label"><g:fieldValue bean="${sucursalInstance}" field="direccion"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${sucursalInstance?.fono}">
				<li class="fieldcontain">
					<span id="fono-label" class="property-label"><g:message code="sucursal.fono.label" default="Fono" /></span>
					
						<span class="property-value" aria-labelledby="fono-label"><g:fieldValue bean="${sucursalInstance}" field="fono"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${sucursalInstance?.comuna}">
				<li class="fieldcontain">
					<span id="comuna-label" class="property-label"><g:message code="sucursal.comuna.label" default="Comuna" /></span>
					
						<span class="property-value" aria-labelledby="comuna-label"><g:link controller="comuna" action="show" id="${sucursalInstance?.comuna?.id}">${sucursalInstance?.comuna?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${sucursalInstance?.estadoInterno}">
				<li class="fieldcontain">
					<span id="estadoInterno-label" class="property-label"><g:message code="sucursal.estadoInterno.label" default="Estado Interno" /></span>
					
						<span class="property-value" aria-labelledby="estadoInterno-label"><g:link controller="estadoInterno" action="show" id="${sucursalInstance?.estadoInterno?.id}">${sucursalInstance?.estadoInterno?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${sucursalInstance?.id}" />
					<g:link class="edit" action="edit" id="${sucursalInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
