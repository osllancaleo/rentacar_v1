
<%@ page import="org.duoc.rentacar.Cliente" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'cliente.label', default: 'Cliente')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-cliente" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-cliente" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list cliente">
			
				<g:if test="${clienteInstance?.rut}">
				<li class="fieldcontain">
					<span id="rut-label" class="property-label"><g:message code="cliente.rut.label" default="Rut" /></span>
					
						<span class="property-value" aria-labelledby="rut-label"><g:fieldValue bean="${clienteInstance}" field="rut"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${clienteInstance?.apellidoPaterno}">
				<li class="fieldcontain">
					<span id="apellidoPaterno-label" class="property-label"><g:message code="cliente.apellidoPaterno.label" default="Apellido Paterno" /></span>
					
						<span class="property-value" aria-labelledby="apellidoPaterno-label"><g:fieldValue bean="${clienteInstance}" field="apellidoPaterno"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${clienteInstance?.nombre}">
				<li class="fieldcontain">
					<span id="nombre-label" class="property-label"><g:message code="cliente.nombre.label" default="Nombre" /></span>
					
						<span class="property-value" aria-labelledby="nombre-label"><g:fieldValue bean="${clienteInstance}" field="nombre"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${clienteInstance?.fechaNacimiento}">
				<li class="fieldcontain">
					<span id="fechaNacimiento-label" class="property-label"><g:message code="cliente.fechaNacimiento.label" default="Fecha Nacimiento" /></span>
					
						<span class="property-value" aria-labelledby="fechaNacimiento-label"><g:formatDate date="${clienteInstance?.fechaNacimiento}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${clienteInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="cliente.email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${clienteInstance}" field="email"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${clienteInstance?.apellidoMaterno}">
				<li class="fieldcontain">
					<span id="apellidoMaterno-label" class="property-label"><g:message code="cliente.apellidoMaterno.label" default="Apellido Materno" /></span>
					
						<span class="property-value" aria-labelledby="apellidoMaterno-label"><g:fieldValue bean="${clienteInstance}" field="apellidoMaterno"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${clienteInstance?.comuna}">
				<li class="fieldcontain">
					<span id="comuna-label" class="property-label"><g:message code="cliente.comuna.label" default="Comuna" /></span>
					
						<span class="property-value" aria-labelledby="comuna-label"><g:link controller="comuna" action="show" id="${clienteInstance?.comuna?.id}">${clienteInstance?.comuna?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${clienteInstance?.direccion}">
				<li class="fieldcontain">
					<span id="direccion-label" class="property-label"><g:message code="cliente.direccion.label" default="Direccion" /></span>
					
						<span class="property-value" aria-labelledby="direccion-label"><g:fieldValue bean="${clienteInstance}" field="direccion"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${clienteInstance?.numeroCelular}">
				<li class="fieldcontain">
					<span id="numeroCelular-label" class="property-label"><g:message code="cliente.numeroCelular.label" default="Numero Celular" /></span>
					
						<span class="property-value" aria-labelledby="numeroCelular-label"><g:fieldValue bean="${clienteInstance}" field="numeroCelular"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${clienteInstance?.numeroFijo}">
				<li class="fieldcontain">
					<span id="numeroFijo-label" class="property-label"><g:message code="cliente.numeroFijo.label" default="Numero Fijo" /></span>
					
						<span class="property-value" aria-labelledby="numeroFijo-label"><g:fieldValue bean="${clienteInstance}" field="numeroFijo"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${clienteInstance?.id}" />
					<g:link class="edit" action="edit" id="${clienteInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
