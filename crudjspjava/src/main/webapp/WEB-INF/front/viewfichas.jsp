<%@page import="crudjspjava.modelo.Ficha"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="crudjspjava.dao.FichaDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Vizualizar </title>
</head>
<body>
	
	<h1> Listagem <h1>
	
	<%
		List<Ficha> list = FichaDAO.getAllFichas();
		request.setAttribute("list", list);
	%>
	
	<table border='1px'> 
		<tr>
			<th> ID </th>
			<th> nome </th> 
			<th> cartãozinho </th> 
			<th> treco </th> 
			<th> trequinho </th>
			
			<c:forEach items="${list}" var="ficha"> 
				<tr>
					<td> ${ficha.getId()} </td>
					<td> ${ficha.getNomePaciente()} </td>
					<td> ${ficha.getNumCarteiraPlano()} </td>
					<td> ${ficha.getPlanoDeSaude()} </td>
					<td> ${ficha.getEspecialidade()} </td>
					<td> <a href="controller?action=editar&id=${ficha.getId()}"> Editar </a> </td>
					<td> <a href="controller?action=apagar&id=${ficha.getId()}"> Apagar </a> </td>
				</tr>
			</c:forEach>
		</tr>
	</table>
		
	</br>
	
	<a href="controller?action=paginaCadastrar"> CADASTRAR</a>
	
</body>
</html>