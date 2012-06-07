<%@ page import="org.duoc.rentacar.EstadoInterno" %>



<div class="fieldcontain ${hasErrors(bean: estadoInternoInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="estadoInterno.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" maxlength="50" required="" value="${estadoInternoInstance?.nombre}"/>
</div>

