<%@ page import="org.duoc.rentacar.Modelo" %>



<div class="fieldcontain ${hasErrors(bean: modeloInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="modelo.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" maxlength="50" required="" value="${modeloInstance?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: modeloInstance, field: 'descripcion', 'error')} required">
	<label for="descripcion">
		<g:message code="modelo.descripcion.label" default="Descripcion" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="descripcion" maxlength="100" required="" value="${modeloInstance?.descripcion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: modeloInstance, field: 'marca', 'error')} required">
	<label for="marca">
		<g:message code="modelo.marca.label" default="Marca" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="marca" name="marca.id" from="${org.duoc.rentacar.Marca.list()}" optionKey="id" required="" value="${modeloInstance?.marca?.id}" class="many-to-one"/>
</div>

