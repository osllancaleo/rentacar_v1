<%@ page import="org.duoc.rentacar.Provincia" %>



<div class="fieldcontain ${hasErrors(bean: provinciaInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="provincia.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" maxlength="50" required="" value="${provinciaInstance?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: provinciaInstance, field: 'comunas', 'error')} ">
	<label for="comunas">
		<g:message code="provincia.comunas.label" default="Comunas" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${provinciaInstance?.comunas?}" var="c">
    <li><g:link controller="comuna" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="comuna" action="create" params="['provincia.id': provinciaInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'comuna.label', default: 'Comuna')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: provinciaInstance, field: 'region', 'error')} required">
	<label for="region">
		<g:message code="provincia.region.label" default="Region" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="region" name="region.id" from="${org.duoc.rentacar.Region.list()}" optionKey="id" required="" value="${provinciaInstance?.region?.id}" class="many-to-one"/>
</div>

