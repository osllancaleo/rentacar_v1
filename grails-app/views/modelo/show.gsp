
<%@ page import="org.duoc.rentacar.Modelo" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'modelo.label', default: 'Modelo')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-modelo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-modelo" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list modelo">
			
				<g:if test="${modeloInstance?.nombre}">
				<li class="fieldcontain">
					<span id="nombre-label" class="property-label"><g:message code="modelo.nombre.label" default="Nombre" /></span>
					
						<span class="property-value" aria-labelledby="nombre-label"><g:fieldValue bean="${modeloInstance}" field="nombre"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${modeloInstance?.descripcion}">
				<li class="fieldcontain">
					<span id="descripcion-label" class="property-label"><g:message code="modelo.descripcion.label" default="Descripcion" /></span>
					
						<span class="property-value" aria-labelledby="descripcion-label"><g:fieldValue bean="${modeloInstance}" field="descripcion"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${modeloInstance?.marca}">
				<li class="fieldcontain">
					<span id="marca-label" class="property-label"><g:message code="modelo.marca.label" default="Marca" /></span>
					
						<span class="property-value" aria-labelledby="marca-label"><g:link controller="marca" action="show" id="${modeloInstance?.marca?.id}">${modeloInstance?.marca?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${modeloInstance?.id}" />
					<g:link class="edit" action="edit" id="${modeloInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
