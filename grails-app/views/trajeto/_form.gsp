<%@ page import="carona.Trajeto" %>



<div class="fieldcontain ${hasErrors(bean: trajetoInstance, field: 'carona', 'error')} required">
	<label for="carona">
		<g:message code="trajeto.carona.label" default="Carona" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="carona" name="carona.id" from="${carona.Carona.list()}" optionKey="id" required="" value="${trajetoInstance?.carona?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: trajetoInstance, field: 'latitudedInicio', 'error')} required">
	<label for="latitudedInicio">
		<g:message code="trajeto.latitudedInicio.label" default="Latituded Inicio" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="latitudedInicio" value="${fieldValue(bean: trajetoInstance, field: 'latitudedInicio')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: trajetoInstance, field: 'latitutdeFim', 'error')} required">
	<label for="latitutdeFim">
		<g:message code="trajeto.latitutdeFim.label" default="Latitutde Fim" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="latitutdeFim" value="${fieldValue(bean: trajetoInstance, field: 'latitutdeFim')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: trajetoInstance, field: 'longitudeFim', 'error')} required">
	<label for="longitudeFim">
		<g:message code="trajeto.longitudeFim.label" default="Longitude Fim" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="longitudeFim" value="${fieldValue(bean: trajetoInstance, field: 'longitudeFim')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: trajetoInstance, field: 'longitudeInicio', 'error')} required">
	<label for="longitudeInicio">
		<g:message code="trajeto.longitudeInicio.label" default="Longitude Inicio" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="longitudeInicio" value="${fieldValue(bean: trajetoInstance, field: 'longitudeInicio')}" required=""/>
</div>

