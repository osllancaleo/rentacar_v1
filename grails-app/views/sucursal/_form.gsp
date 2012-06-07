<%@ page import="org.duoc.rentacar.Sucursal" %>



<div class="fieldcontain ${hasErrors(bean: sucursalInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="sucursal.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" maxlength="50" required="" value="${sucursalInstance?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: sucursalInstance, field: 'direccion', 'error')} required">
	<label for="direccion">
		<g:message code="sucursal.direccion.label" default="Direccion" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="direccion" maxlength="80" required="" value="${sucursalInstance?.direccion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: sucursalInstance, field: 'fono', 'error')} required">
	<label for="fono">
		<g:message code="sucursal.fono.label" default="Fono" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="fono" min="100000" required="" value="${fieldValue(bean: sucursalInstance, field: 'fono')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: sucursalInstance, field: 'comuna', 'error')} required">
	<label for="comuna">
		<g:message code="sucursal.comuna.label" default="Comuna" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="comuna" name="comuna.id" from="${org.duoc.rentacar.Comuna.list()}" optionKey="id" required="" value="${sucursalInstance?.comuna?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: sucursalInstance, field: 'estadoInterno', 'error')} required">
	<label for="estadoInterno">
		<g:message code="sucursal.estadoInterno.label" default="Estado Interno" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="estadoInterno" name="estadoInterno.id" from="${org.duoc.rentacar.EstadoInterno.list()}" optionKey="id" required="" value="${sucursalInstance?.estadoInterno?.id}" class="many-to-one"/>
</div>

