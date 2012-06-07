
<%@ page import="org.duoc.rentacar.Region" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'region.label', default: 'Region')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-region" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-region" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list region">
			
				<g:if test="${regionInstance?.nombre}">
				<li class="fieldcontain">
					<span id="nombre-label" class="property-label"><g:message code="region.nombre.label" default="Nombre" /></span>
					
						<span class="property-value" aria-labelledby="nombre-label"><g:fieldValue bean="${regionInstance}" field="nombre"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${regionInstance?.provincias}">
				<li class="fieldcontain">
					<span id="provincias-label" class="property-label"><g:message code="region.provincias.label" default="Provincias" /></span>
					
						<g:each in="${regionInstance.provincias}" var="p">
						<span class="property-value" aria-labelledby="provincias-label"><g:link controller="provincia" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${regionInstance?.id}" />
					<g:link class="edit" action="edit" id="${regionInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
