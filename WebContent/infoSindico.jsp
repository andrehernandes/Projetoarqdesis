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
		<% System.out.printf("Síndico: "+session.getAttribute("sindico")+" Atendente: "+session.getAttribute("atendente")+" Funcionário: "+session.getAttribute("funcionario")); %>
		<h3 class="page-header">Informações da Pessoa #${sindico.id}</h3>
		<p>
			Nome: ${sindico.nome}<br>
			Tipo: ${sindico.tipo}<br>
			Cpf:  ${sindico.cpf}<br>
		</p>
		<div class="login-page">
		<b>Ações disponíveis</b>
		<form>
		<button type="submit" class="btn btn-primary" name="command"
						value="TelaCadastrarFuncionario"
						method="post">Cadastrar Funcionario</button>
		</form>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>