
<%@ page import="carona.Carona" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'carona.label', default: 'Carona')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-carona" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-carona" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="bairroDestino" title="${message(code: 'carona.bairroDestino.label', default: 'Bairro Destino')}" />
					
						<g:sortableColumn property="bairroPartida" title="${message(code: 'carona.bairroPartida.label', default: 'Bairro Partida')}" />
					
						<g:sortableColumn property="data" title="${message(code: 'carona.data.label', default: 'Data')}" />
					
						<g:sortableColumn property="localDestino" title="${message(code: 'carona.localDestino.label', default: 'Local Destino')}" />
					
						<th><g:message code="carona.trajeto.label" default="Trajeto" /></th>
					
						<g:sortableColumn property="vagas" title="${message(code: 'carona.vagas.label', default: 'Vagas')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${caronaInstanceList}" status="i" var="caronaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${caronaInstance.id}">${fieldValue(bean: caronaInstance, field: "bairroDestino")}</g:link></td>
					
						<td>${fieldValue(bean: caronaInstance, field: "bairroPartida")}</td>
					
						<td><g:formatDate date="${caronaInstance.data}" /></td>
					
						<td>${fieldValue(bean: caronaInstance, field: "localDestino")}</td>
					
						<td>${fieldValue(bean: caronaInstance, field: "trajeto")}</td>
					
						<td>${fieldValue(bean: caronaInstance, field: "vagas")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${caronaInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
