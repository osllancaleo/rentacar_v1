<%@ page import="org.duoc.rentacar.Cliente" %>



<div class="fieldcontain ${hasErrors(bean: clienteInstance, field: 'rut', 'error')} required">
	<label for="rut">
		<g:message code="cliente.rut.label" default="Rut" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="rut" maxlength="8" required="" value="${clienteInstance?.rut}"/>
</div>
<div class="fieldcontain ${hasErrors(bean: clienteInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="cliente.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" required="" value="${clienteInstance?.nombre}"/>
</div>
<div class="fieldcontain ${hasErrors(bean: clienteInstance, field: 'apellidoPaterno', 'error')} required">
	<label for="apellidoPaterno">
		<g:message code="cliente.apellidoPaterno.label" default="Apellido Paterno" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="apellidoPaterno" required="" value="${clienteInstance?.apellidoPaterno}"/>
</div>
<div class="fieldcontain ${hasErrors(bean: clienteInstance, field: 'apellidoMaterno', 'error')} ">
	<label for="apellidoMaterno">
		<g:message code="cliente.apellidoMaterno.label" default="Apellido Materno" />
		
	</label>
	<g:textField name="apellidoMaterno" value="${clienteInstance?.apellidoMaterno}"/>
</div>


<div class="fieldcontain ${hasErrors(bean: clienteInstance, field: 'fechaNacimiento', 'error')} required">
	<label for="fechaNacimiento">
		<g:message code="cliente.fechaNacimiento.label" default="Fecha Nacimiento" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fechaNacimiento" precision="day"  value="${clienteInstance?.fechaNacimiento}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: clienteInstance, field: 'email', 'error')} ">
	<label for="email">
		<g:message code="cliente.email.label" default="Email" />
		
	</label>
	<g:field type="email" name="email" value="${clienteInstance?.email}"/>
</div>



<div class="fieldcontain ${hasErrors(bean: clienteInstance, field: 'comuna', 'error')} required">
	<label for="comuna">
		<g:message code="cliente.comuna.label" default="Comuna" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="comuna" name="comuna.id" from="${org.duoc.rentacar.Comuna.list()}" optionKey="id" required="" value="${clienteInstance?.comuna?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: clienteInstance, field: 'direccion', 'error')} ">
	<label for="direccion">
		<g:message code="cliente.direccion.label" default="Direccion" />
		
	</label>
	<g:textField name="direccion" value="${clienteInstance?.direccion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: clienteInstance, field: 'numeroCelular', 'error')} required">
	<label for="numeroCelular">
		<g:message code="cliente.numeroCelular.label" default="Numero Celular" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="numeroCelular" required="" value="${fieldValue(bean: clienteInstance, field: 'numeroCelular')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: clienteInstance, field: 'numeroFijo', 'error')} required">
	<label for="numeroFijo">
		<g:message code="cliente.numeroFijo.label" default="Numero Fijo" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="numeroFijo" required="" value="${fieldValue(bean: clienteInstance, field: 'numeroFijo')}"/>
</div>

