<%@ page import="org.duoc.rentacar.EstadoVehiculo" %>



<div class="fieldcontain ${hasErrors(bean: estadoVehiculoInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="estadoVehiculo.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" maxlength="50" required="" value="${estadoVehiculoInstance?.nombre}"/>
</div>

