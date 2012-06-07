<%@ page import="org.duoc.rentacar.TipoVehiculo" %>



<div class="fieldcontain ${hasErrors(bean: tipoVehiculoInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="tipoVehiculo.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" maxlength="30" required="" value="${tipoVehiculoInstance?.nombre}"/>
</div>

