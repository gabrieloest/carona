<%@ page import="carona.Carona" %>



<div class="fieldcontain ${hasErrors(bean: caronaInstance, field: 'bairroDestino', 'error')} ">
	<label for="bairroDestino">
		<g:message code="carona.bairroDestino.label" default="Bairro Destino" />
		
	</label>
	<g:textField name="bairroDestino" value="${caronaInstance?.bairroDestino}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: caronaInstance, field: 'bairroPartida', 'error')} ">
	<label for="bairroPartida">
		<g:message code="carona.bairroPartida.label" default="Bairro Partida" />
		
	</label>
	<g:textField name="bairroPartida" value="${caronaInstance?.bairroPartida}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: caronaInstance, field: 'data', 'error')} required">
	<label for="data">
		<g:message code="carona.data.label" default="Data" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="data" precision="day"  value="${caronaInstance?.data}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: caronaInstance, field: 'localDestino', 'error')} ">
	<label for="localDestino">
		<g:message code="carona.localDestino.label" default="Local Destino" />
		
	</label>
	<g:textField name="localDestino" value="${caronaInstance?.localDestino}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: caronaInstance, field: 'trajeto', 'error')} required">
	<label for="trajeto">
		<g:message code="carona.trajeto.label" default="Trajeto" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="trajeto" name="trajeto.id" from="${carona.Trajeto.list()}" optionKey="id" required="" value="${caronaInstance?.trajeto?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: caronaInstance, field: 'vagas', 'error')} required">
	<label for="vagas">
		<g:message code="carona.vagas.label" default="Vagas" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="vagas" type="number" value="${caronaInstance.vagas}" required=""/>
</div>

