
<%@ page import="org.duoc.rentacar.Provincia" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'provincia.label', default: 'Provincia')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-provincia" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-provincia" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list provincia">
			
				<g:if test="${provinciaInstance?.nombre}">
				<li class="fieldcontain">
					<span id="nombre-label" class="property-label"><g:message code="provincia.nombre.label" default="Nombre" /></span>
					
						<span class="property-value" aria-labelledby="nombre-label"><g:fieldValue bean="${provinciaInstance}" field="nombre"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${provinciaInstance?.comunas}">
				<li class="fieldcontain">
					<span id="comunas-label" class="property-label"><g:message code="provincia.comunas.label" default="Comunas" /></span>
					
						<g:each in="${provinciaInstance.comunas}" var="c">
						<span class="property-value" aria-labelledby="comunas-label"><g:link controller="comuna" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${provinciaInstance?.region}">
				<li class="fieldcontain">
					<span id="region-label" class="property-label"><g:message code="provincia.region.label" default="Region" /></span>
					
						<span class="property-value" aria-labelledby="region-label"><g:link controller="region" action="show" id="${provinciaInstance?.region?.id}">${provinciaInstance?.region?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${provinciaInstance?.id}" />
					<g:link class="edit" action="edit" id="${provinciaInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
