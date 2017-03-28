<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="funcionario" class="Classes.Funcionario" scope="session"/>

<jsp:useBean id="atendente" class="Classes.Atendente" scope="session"/>

<jsp:useBean id="sindico" class="Classes.Sindico" scope="session"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Catraca</title>
</head>
<body>

	<!-- Barra superior com os menus de navegação -->
	<!-- Container Principal -->
	
	<div id="main" class="container">
		<%System.out.printf("Síndico: "+session.getAttribute("sindico")+" Atendente: "+session.getAttribute("atendente")+" Funcionário: "+session.getAttribute("funcionario")); %>
		<c:if test="${not empty sindico}">
		<h3 class="page-header">Informações da Pessoa #${sindico.id}</h3>
		<p>
			Nome: ${sindico.nome}<br>
			Tipo: ${sindico.tipo}<br>
			Cpf:  ${sindico.cpf}<br>
		</p>
		</c:if>
		<c:if test="${not empty atendente}">
		<h3 class="page-header">Informações da Pessoa #${atendente.id}</h3>
		<p>
			Nome: ${atendente.nome}<br>
			Tipo: ${atendente.tipo}<br>
			Cpf:  ${atendente.cpf}<br>
		</p>
		</c:if>
		<c:if test="${not empty funcionario}">
		<h3 class="page-header">Informações da Pessoa #${funcionario.id}</h3>
		<p>
			Nome: ${funcionario.nome}<br>
			Tipo: ${funcionario.tipo}<br>
			Cpf:  ${funcionario.cpf}<br>
			Data de Cadastro: ${funcionario.data} <br>
			Data de entrada: ${funcionario.horarioEntrada} <br>
			Data de saída: ${funcionario.horarioSaida} <br>
		</p>
		</c:if>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>