<%@ page import="org.duoc.rentacar.Motor" %>



<div class="fieldcontain ${hasErrors(bean: motorInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="motor.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" maxlength="20" required="" value="${motorInstance?.nombre}"/>
</div>

