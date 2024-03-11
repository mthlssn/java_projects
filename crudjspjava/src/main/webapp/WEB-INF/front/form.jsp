<%@page import="crudjspjava.dao.FichaDAO"%>
<%@page import="crudjspjava.modelo.Ficha"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@page import="crudjspjava.modelo.PlanoDeSaude"%>
<%@page import="crudjspjava.modelo.Especialidade"%>
<%@page import="crudjspjava.dao.EspecialidadeDAO"%>
<%@page import="crudjspjava.dao.PlanoDeSaudeDAO"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	List<PlanoDeSaude> listPlanos = PlanoDeSaudeDAO.getAllPlanosDeSaude();
	request.setAttribute("listPlanos", listPlanos);
			
	List<Especialidade> listEspecialidades = EspecialidadeDAO.getAllEspecialidades();
	request.setAttribute("listEspecialidades", listEspecialidades);	

	Ficha ficha = new Ficha();
	
	String title = "";
	String action = "";
	String valueNomePaciente = "";
	String valueNumCarteiraPlano = "";
	String selecionado = "";
	int idPlan = 0;
	int idEsp = 0;
	
	int cont = 0;
	
	int id = Integer.parseInt(request.getParameter("id"));
	
	if (id == 0) {
		action = "controller?action=cadastrarFicha";
		
		title = "Cadastrar Ficha";
	} else {
		
		action = "controller?action=editarFicha&id="+id;
		
		title = "Editar Ficha";
		
		ficha = FichaDAO.getFichaById(id);
		
		valueNomePaciente = ficha.getNomePaciente();
		valueNumCarteiraPlano = ficha.getNumCarteiraPlano();
		
		idPlan = PlanoDeSaudeDAO.getIdByName(ficha.getPlanoDeSaude());
		idEsp = EspecialidadeDAO.getIdByName(ficha.getEspecialidade());
	} 
%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title> <%= title %> </title>
</head>
<body>
	<form action="<%=action%>" method="post">
		<table>
			<tr> 
				<td> Nome Paciente: </td>
				<td> <input type="text" name="nomePaciente" value="<%=valueNomePaciente%>"> </td>
			</tr>
			<tr> 
				<td> Numero da Carteira do Plano </td>
				<td> <input type="text" name="numCarteiraPlano" value="<%=valueNumCarteiraPlano%>"> </td>
			</tr>
			<tr> 
				<td> Plano de Saúde: </td>
				<td>
					<select name="planoDeSaude">
						<c:forEach items="${listPlanos}" var="plan"> 
							<%
								cont++;
								selecionado = "";
								if (cont == idPlan) {
									selecionado = "selected";
								}
							%>
							<option <%=selecionado%>> ${plan.getNome()} </option>
						</c:forEach>
					</select>
				</td>
			</tr>
			
			<%
				cont = 0;
				selecionado = "";
			%>
			
			<tr> 
				<td> Especialidade </td>
				<td>
					<select name="especialidade">
						<c:forEach items="${listEspecialidades}" var="esp"> 
							<%
								cont++;
								selecionado = "";
								if (cont == idEsp) {
									selecionado = "selected";
								}
							%>
							<option <%=selecionado%>> ${esp.getNome()} </option>
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