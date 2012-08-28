
<%@ page import="carona.Carona" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'carona.label', default: 'Carona')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-carona" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-carona" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list carona">
			
				<g:if test="${caronaInstance?.bairroDestino}">
				<li class="fieldcontain">
					<span id="bairroDestino-label" class="property-label"><g:message code="carona.bairroDestino.label" default="Bairro Destino" /></span>
					
						<span class="property-value" aria-labelledby="bairroDestino-label"><g:fieldValue bean="${caronaInstance}" field="bairroDestino"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${caronaInstance?.bairroPartida}">
				<li class="fieldcontain">
					<span id="bairroPartida-label" class="property-label"><g:message code="carona.bairroPartida.label" default="Bairro Partida" /></span>
					
						<span class="property-value" aria-labelledby="bairroPartida-label"><g:fieldValue bean="${caronaInstance}" field="bairroPartida"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${caronaInstance?.data}">
				<li class="fieldcontain">
					<span id="data-label" class="property-label"><g:message code="carona.data.label" default="Data" /></span>
					
						<span class="property-value" aria-labelledby="data-label"><g:formatDate date="${caronaInstance?.data}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${caronaInstance?.localDestino}">
				<li class="fieldcontain">
					<span id="localDestino-label" class="property-label"><g:message code="carona.localDestino.label" default="Local Destino" /></span>
					
						<span class="property-value" aria-labelledby="localDestino-label"><g:fieldValue bean="${caronaInstance}" field="localDestino"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${caronaInstance?.trajeto}">
				<li class="fieldcontain">
					<span id="trajeto-label" class="property-label"><g:message code="carona.trajeto.label" default="Trajeto" /></span>
					
						<span class="property-value" aria-labelledby="trajeto-label"><g:link controller="trajeto" action="show" id="${caronaInstance?.trajeto?.id}">${caronaInstance?.trajeto?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${caronaInstance?.vagas}">
				<li class="fieldcontain">
					<span id="vagas-label" class="property-label"><g:message code="carona.vagas.label" default="Vagas" /></span>
					
						<span class="property-value" aria-labelledby="vagas-label"><g:fieldValue bean="${caronaInstance}" field="vagas"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${caronaInstance?.id}" />
					<g:link class="edit" action="edit" id="${caronaInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
