<%@ page import="org.duoc.rentacar.Vehiculo" %>



<div class="fieldcontain ${hasErrors(bean: vehiculoInstance, field: 'patente', 'error')} required">
	<label for="patente">
		<g:message code="vehiculo.patente.label" default="Patente" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="patente" maxlength="6" required="" value="${vehiculoInstance?.patente}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: vehiculoInstance, field: 'anio', 'error')} required">
	<label for="anio">
		<g:message code="vehiculo.anio.label" default="Anio" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="anio" min="1995" required="" value="${fieldValue(bean: vehiculoInstance, field: 'anio')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: vehiculoInstance, field: 'valorDia', 'error')} required">
	<label for="valorDia">
		<g:message code="vehiculo.valorDia.label" default="Valor Dia" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="valorDia" min="1" required="" value="${fieldValue(bean: vehiculoInstance, field: 'valorDia')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: vehiculoInstance, field: 'valorHora', 'error')} required">
	<label for="valorHora">
		<g:message code="vehiculo.valorHora.label" default="Valor Hora" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="valorHora" min="1" required="" value="${fieldValue(bean: vehiculoInstance, field: 'valorHora')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: vehiculoInstance, field: 'rendimiento', 'error')} required">
	<label for="rendimiento">
		<g:message code="vehiculo.rendimiento.label" default="Rendimiento" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="rendimiento" maxlength="50" required="" value="${vehiculoInstance?.rendimiento}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: vehiculoInstance, field: 'cantidadPasajero', 'error')} required">
	<label for="cantidadPasajero">
		<g:message code="vehiculo.cantidadPasajero.label" default="Cantidad Pasajero" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="cantidadPasajero" min="2" max="40" required="" value="${fieldValue(bean: vehiculoInstance, field: 'cantidadPasajero')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: vehiculoInstance, field: 'airBag', 'error')} ">
	<label for="airBag">
		<g:message code="vehiculo.airBag.label" default="Air Bag" />
		
	</label>
	<g:checkBox name="airBag" value="${vehiculoInstance?.airBag}" />
</div>

<div class="fieldcontain ${hasErrors(bean: vehiculoInstance, field: 'cierreCentralizado', 'error')} ">
	<label for="cierreCentralizado">
		<g:message code="vehiculo.cierreCentralizado.label" default="Cierre Centralizado" />
		
	</label>
	<g:checkBox name="cierreCentralizado" value="${vehiculoInstance?.cierreCentralizado}" />
</div>

<div class="fieldcontain ${hasErrors(bean: vehiculoInstance, field: 'color', 'error')} required">
	<label for="color">
		<g:message code="vehiculo.color.label" default="Color" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="color" name="color.id" from="${org.duoc.rentacar.Color.list()}" optionKey="id" required="" value="${vehiculoInstance?.color?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: vehiculoInstance, field: 'estadovehiculo', 'error')} required">
	<label for="estadovehiculo">
		<g:message code="vehiculo.estadovehiculo.label" default="Estadovehiculo" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="estadovehiculo" name="estadovehiculo.id" from="${org.duoc.rentacar.EstadoVehiculo.list()}" optionKey="id" required="" value="${vehiculoInstance?.estadovehiculo?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: vehiculoInstance, field: 'modelo', 'error')} required">
	<label for="modelo">
		<g:message code="vehiculo.modelo.label" default="Modelo" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="modelo" name="modelo.id" from="${org.duoc.rentacar.Modelo.list()}" optionKey="id" required="" value="${vehiculoInstance?.modelo?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: vehiculoInstance, field: 'motor', 'error')} required">
	<label for="motor">
		<g:message code="vehiculo.motor.label" default="Motor" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="motor" name="motor.id" from="${org.duoc.rentacar.Motor.list()}" optionKey="id" required="" value="${vehiculoInstance?.motor?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: vehiculoInstance, field: 'sucursal', 'error')} required">
	<label for="sucursal">
		<g:message code="vehiculo.sucursal.label" default="Sucursal" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="sucursal" name="sucursal.id" from="${org.duoc.rentacar.Sucursal.list()}" optionKey="id" required="" value="${vehiculoInstance?.sucursal?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: vehiculoInstance, field: 'tipovehiculo', 'error')} required">
	<label for="tipovehiculo">
		<g:message code="vehiculo.tipovehiculo.label" default="Tipovehiculo" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="tipovehiculo" name="tipovehiculo.id" from="${org.duoc.rentacar.TipoVehiculo.list()}" optionKey="id" required="" value="${vehiculoInstance?.tipovehiculo?.id}" class="many-to-one"/>
</div>

