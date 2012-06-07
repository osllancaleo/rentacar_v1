<%@ page import="org.duoc.rentacar.EstadoReserva" %>



<div class="fieldcontain ${hasErrors(bean: estadoReservaInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="estadoReserva.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" maxlength="50" required="" value="${estadoReservaInstance?.nombre}"/>
</div>

