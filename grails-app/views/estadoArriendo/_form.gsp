<%@ page import="org.duoc.rentacar.EstadoArriendo" %>



<div class="fieldcontain ${hasErrors(bean: estadoArriendoInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="estadoArriendo.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" maxlength="50" required="" value="${estadoArriendoInstance?.nombre}"/>
</div>

