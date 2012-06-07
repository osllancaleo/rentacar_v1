<%@ page import="org.duoc.rentacar.Region" %>



<div class="fieldcontain ${hasErrors(bean: regionInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="region.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" maxlength="50" required="" value="${regionInstance?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: regionInstance, field: 'provincias', 'error')} ">
	<label for="provincias">
		<g:message code="region.provincias.label" default="Provincias" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${regionInstance?.provincias?}" var="p">
    <li><g:link controller="provincia" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="provincia" action="create" params="['region.id': regionInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'provincia.label', default: 'Provincia')])}</g:link>
</li>
</ul>

</div>

