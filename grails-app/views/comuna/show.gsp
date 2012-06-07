
<%@ page import="org.duoc.rentacar.Comuna" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'comuna.label', default: 'Comuna')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-comuna" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-comuna" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list comuna">
			
				<g:if test="${comunaInstance?.nombre}">
				<li class="fieldcontain">
					<span id="nombre-label" class="property-label"><g:message code="comuna.nombre.label" default="Nombre" /></span>
					
						<span class="property-value" aria-labelledby="nombre-label"><g:fieldValue bean="${comunaInstance}" field="nombre"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${comunaInstance?.provincia}">
				<li class="fieldcontain">
					<span id="provincia-label" class="property-label"><g:message code="comuna.provincia.label" default="Provincia" /></span>
					
						<span class="property-value" aria-labelledby="provincia-label"><g:link controller="provincia" action="show" id="${comunaInstance?.provincia?.id}">${comunaInstance?.provincia?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${comunaInstance?.id}" />
					<g:link class="edit" action="edit" id="${comunaInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
