<%@ page import="org.duoc.rentacar.Comuna" %>



<div class="fieldcontain ${hasErrors(bean: comunaInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="comuna.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" maxlength="50" required="" value="${comunaInstance?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: comunaInstance, field: 'provincia', 'error')} required">
	<label for="provincia">
		<g:message code="comuna.provincia.label" default="Provincia" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="provincia" name="provincia.id" from="${org.duoc.rentacar.Provincia.list()}" optionKey="id" required="" value="${comunaInstance?.provincia?.id}" class="many-to-one"/>
</div>

