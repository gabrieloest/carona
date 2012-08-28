
<%@ page import="carona.Trajeto" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'trajeto.label', default: 'Trajeto')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-trajeto" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-trajeto" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="trajeto.carona.label" default="Carona" /></th>
					
						<g:sortableColumn property="latitudedInicio" title="${message(code: 'trajeto.latitudedInicio.label', default: 'Latituded Inicio')}" />
					
						<g:sortableColumn property="latitutdeFim" title="${message(code: 'trajeto.latitutdeFim.label', default: 'Latitutde Fim')}" />
					
						<g:sortableColumn property="longitudeFim" title="${message(code: 'trajeto.longitudeFim.label', default: 'Longitude Fim')}" />
					
						<g:sortableColumn property="longitudeInicio" title="${message(code: 'trajeto.longitudeInicio.label', default: 'Longitude Inicio')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${trajetoInstanceList}" status="i" var="trajetoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${trajetoInstance.id}">${fieldValue(bean: trajetoInstance, field: "carona")}</g:link></td>
					
						<td>${fieldValue(bean: trajetoInstance, field: "latitudedInicio")}</td>
					
						<td>${fieldValue(bean: trajetoInstance, field: "latitutdeFim")}</td>
					
						<td>${fieldValue(bean: trajetoInstance, field: "longitudeFim")}</td>
					
						<td>${fieldValue(bean: trajetoInstance, field: "longitudeInicio")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${trajetoInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
