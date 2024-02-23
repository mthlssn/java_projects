<%@page import="crudjspjava.modelo.PlanoDeSaude"%>
<%@page import="crudjspjava.modelo.Especialidade"%>
<%@page import="crudjspjava.dao.EspecialidadeDAO"%>
<%@page import="crudjspjava.dao.PlanoDeSaudeDAO"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Formulario </title>
</head>
<body>
	<form action="controller?action=cadastrarFicha" method="post">
	
		<%
			List<PlanoDeSaude> listPlanos = PlanoDeSaudeDAO.getAllPlanosDeSaude();
			request.setAttribute("listPlanos", listPlanos);
			
			List<Especialidade> listEspecialidades = EspecialidadeDAO.getAllEspecialidades();
			request.setAttribute("listEspecialidades", listEspecialidades);
		%>
		
		<table>
			<tr> 
				<td> Nome Paciente: </td>
				<td> <input type="text" name="nomePaciente"> </td>
			</tr>
			<tr> 
				<td> Numero da Carteira do Plano </td>
				<td> <input type="text" name="numCarteiraPlano"> </td>
			</tr>
			<tr> 
				<td> Plano de Saúde: </td>
				<td>
					<select name="planoDeSaude">
						<c:forEach items="${listPlanos}" var="plan"> 
							<option> ${plan.getNome()} </option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr> 
				<td> Especialidade </td>
				<td>
					<select name="especialidade">
						<c:forEach items="${listEspecialidades}" var="esp"> 
							<option> ${esp.getNome()} </option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr> 
				<td> 
					<input type="submit" value="enviar"> 
				</td> 
			</tr>
		</table>
	</form>
</body>
</html>