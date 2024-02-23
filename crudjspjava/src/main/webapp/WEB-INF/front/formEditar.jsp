<%@page import="crudjspjava.modelo.Ficha"%>
<%@page import="crudjspjava.dao.FichaDAO"%>
<%@page import="crudjspjava.modelo.Especialidade"%>
<%@page import="crudjspjava.dao.EspecialidadeDAO"%>
<%@page import="crudjspjava.dao.PlanoDeSaudeDAO"%>
<%@page import="crudjspjava.modelo.PlanoDeSaude"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="controller?action=editarFicha" method="post">
		<%
			String id = request.getParameter("id");
		
			Ficha ficha = FichaDAO.getFichaById(Integer.parseInt(id));
		
			List<PlanoDeSaude> listPlanos = PlanoDeSaudeDAO.getAllPlanosDeSaude();
			request.setAttribute("listPlanos", listPlanos);
			
			List<Especialidade> listEspecialidades = EspecialidadeDAO.getAllEspecialidades();
			request.setAttribute("listEspecialidades", listEspecialidades);
		%>
		
		<input hidden type="text" name="id" value="<%=id%>">
		
		<table>
			<tr> 
				<td> Nome Paciente: </td>
				<td> <input type="text" name="nomePaciente" value="<%=ficha.getNomePaciente()%>"> </td>
			</tr>
			<tr> 
				<td> Numero da Carteira do Plano </td>
				<td> <input type="text" name="numCarteiraPlano" value="<%=ficha.getNumCarteiraPlano()%>"> </td>
			</tr>
			<tr> 
				<td> Plano de Saúde: </td>
				<td>
					<select name="planoDeSaude">
						<c:forEach items="${listPlanos}" var="plan"> 
							<option> ${plan.getNome()} </option>s
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