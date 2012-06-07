<%@ page import="org.duoc.rentacar.Color" %>



<div class="fieldcontain ${hasErrors(bean: colorInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="color.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" maxlength="50" required="" value="${colorInstance?.nombre}"/>
</div>

