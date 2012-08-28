
<%@ page import="carona.Trajeto" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'trajeto.label', default: 'Trajeto')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-trajeto" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-trajeto" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list trajeto">
			
				<g:if test="${trajetoInstance?.carona}">
				<li class="fieldcontain">
					<span id="carona-label" class="property-label"><g:message code="trajeto.carona.label" default="Carona" /></span>
					
						<span class="property-value" aria-labelledby="carona-label"><g:link controller="carona" action="show" id="${trajetoInstance?.carona?.id}">${trajetoInstance?.carona?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${trajetoInstance?.latitudedInicio}">
				<li class="fieldcontain">
					<span id="latitudedInicio-label" class="property-label"><g:message code="trajeto.latitudedInicio.label" default="Latituded Inicio" /></span>
					
						<span class="property-value" aria-labelledby="latitudedInicio-label"><g:fieldValue bean="${trajetoInstance}" field="latitudedInicio"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${trajetoInstance?.latitutdeFim}">
				<li class="fieldcontain">
					<span id="latitutdeFim-label" class="property-label"><g:message code="trajeto.latitutdeFim.label" default="Latitutde Fim" /></span>
					
						<span class="property-value" aria-labelledby="latitutdeFim-label"><g:fieldValue bean="${trajetoInstance}" field="latitutdeFim"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${trajetoInstance?.longitudeFim}">
				<li class="fieldcontain">
					<span id="longitudeFim-label" class="property-label"><g:message code="trajeto.longitudeFim.label" default="Longitude Fim" /></span>
					
						<span class="property-value" aria-labelledby="longitudeFim-label"><g:fieldValue bean="${trajetoInstance}" field="longitudeFim"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${trajetoInstance?.longitudeInicio}">
				<li class="fieldcontain">
					<span id="longitudeInicio-label" class="property-label"><g:message code="trajeto.longitudeInicio.label" default="Longitude Inicio" /></span>
					
						<span class="property-value" aria-labelledby="longitudeInicio-label"><g:fieldValue bean="${trajetoInstance}" field="longitudeInicio"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${trajetoInstance?.id}" />
					<g:link class="edit" action="edit" id="${trajetoInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
