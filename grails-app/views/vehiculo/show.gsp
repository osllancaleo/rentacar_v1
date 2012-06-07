
<%@ page import="org.duoc.rentacar.Vehiculo" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'vehiculo.label', default: 'Vehiculo')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-vehiculo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-vehiculo" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list vehiculo">
			
				<g:if test="${vehiculoInstance?.patente}">
				<li class="fieldcontain">
					<span id="patente-label" class="property-label"><g:message code="vehiculo.patente.label" default="Patente" /></span>
					
						<span class="property-value" aria-labelledby="patente-label"><g:fieldValue bean="${vehiculoInstance}" field="patente"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehiculoInstance?.anio}">
				<li class="fieldcontain">
					<span id="anio-label" class="property-label"><g:message code="vehiculo.anio.label" default="Anio" /></span>
					
						<span class="property-value" aria-labelledby="anio-label"><g:fieldValue bean="${vehiculoInstance}" field="anio"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehiculoInstance?.valorDia}">
				<li class="fieldcontain">
					<span id="valorDia-label" class="property-label"><g:message code="vehiculo.valorDia.label" default="Valor Dia" /></span>
					
						<span class="property-value" aria-labelledby="valorDia-label"><g:fieldValue bean="${vehiculoInstance}" field="valorDia"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehiculoInstance?.valorHora}">
				<li class="fieldcontain">
					<span id="valorHora-label" class="property-label"><g:message code="vehiculo.valorHora.label" default="Valor Hora" /></span>
					
						<span class="property-value" aria-labelledby="valorHora-label"><g:fieldValue bean="${vehiculoInstance}" field="valorHora"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehiculoInstance?.rendimiento}">
				<li class="fieldcontain">
					<span id="rendimiento-label" class="property-label"><g:message code="vehiculo.rendimiento.label" default="Rendimiento" /></span>
					
						<span class="property-value" aria-labelledby="rendimiento-label"><g:fieldValue bean="${vehiculoInstance}" field="rendimiento"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehiculoInstance?.cantidadPasajero}">
				<li class="fieldcontain">
					<span id="cantidadPasajero-label" class="property-label"><g:message code="vehiculo.cantidadPasajero.label" default="Cantidad Pasajero" /></span>
					
						<span class="property-value" aria-labelledby="cantidadPasajero-label"><g:fieldValue bean="${vehiculoInstance}" field="cantidadPasajero"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehiculoInstance?.airBag}">
				<li class="fieldcontain">
					<span id="airBag-label" class="property-label"><g:message code="vehiculo.airBag.label" default="Air Bag" /></span>
					
						<span class="property-value" aria-labelledby="airBag-label"><g:formatBoolean boolean="${vehiculoInstance?.airBag}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehiculoInstance?.cierreCentralizado}">
				<li class="fieldcontain">
					<span id="cierreCentralizado-label" class="property-label"><g:message code="vehiculo.cierreCentralizado.label" default="Cierre Centralizado" /></span>
					
						<span class="property-value" aria-labelledby="cierreCentralizado-label"><g:formatBoolean boolean="${vehiculoInstance?.cierreCentralizado}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehiculoInstance?.color}">
				<li class="fieldcontain">
					<span id="color-label" class="property-label"><g:message code="vehiculo.color.label" default="Color" /></span>
					
						<span class="property-value" aria-labelledby="color-label"><g:link controller="color" action="show" id="${vehiculoInstance?.color?.id}">${vehiculoInstance?.color?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehiculoInstance?.estadovehiculo}">
				<li class="fieldcontain">
					<span id="estadovehiculo-label" class="property-label"><g:message code="vehiculo.estadovehiculo.label" default="Estadovehiculo" /></span>
					
						<span class="property-value" aria-labelledby="estadovehiculo-label"><g:link controller="estadoVehiculo" action="show" id="${vehiculoInstance?.estadovehiculo?.id}">${vehiculoInstance?.estadovehiculo?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehiculoInstance?.modelo}">
				<li class="fieldcontain">
					<span id="modelo-label" class="property-label"><g:message code="vehiculo.modelo.label" default="Modelo" /></span>
					
						<span class="property-value" aria-labelledby="modelo-label"><g:link controller="modelo" action="show" id="${vehiculoInstance?.modelo?.id}">${vehiculoInstance?.modelo?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehiculoInstance?.motor}">
				<li class="fieldcontain">
					<span id="motor-label" class="property-label"><g:message code="vehiculo.motor.label" default="Motor" /></span>
					
						<span class="property-value" aria-labelledby="motor-label"><g:link controller="motor" action="show" id="${vehiculoInstance?.motor?.id}">${vehiculoInstance?.motor?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehiculoInstance?.sucursal}">
				<li class="fieldcontain">
					<span id="sucursal-label" class="property-label"><g:message code="vehiculo.sucursal.label" default="Sucursal" /></span>
					
						<span class="property-value" aria-labelledby="sucursal-label"><g:link controller="sucursal" action="show" id="${vehiculoInstance?.sucursal?.id}">${vehiculoInstance?.sucursal?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehiculoInstance?.tipovehiculo}">
				<li class="fieldcontain">
					<span id="tipovehiculo-label" class="property-label"><g:message code="vehiculo.tipovehiculo.label" default="Tipovehiculo" /></span>
					
						<span class="property-value" aria-labelledby="tipovehiculo-label"><g:link controller="tipoVehiculo" action="show" id="${vehiculoInstance?.tipovehiculo?.id}">${vehiculoInstance?.tipovehiculo?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${vehiculoInstance?.id}" />
					<g:link class="edit" action="edit" id="${vehiculoInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
