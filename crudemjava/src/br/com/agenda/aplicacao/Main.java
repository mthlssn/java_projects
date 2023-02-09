package br.com.agenda.aplicacao;

import java.util.Date;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Contato contato = new Contato();
		ContatoDAO contatoDAO = new ContatoDAO();
		
		contato.setNome("Ariana");
		contato.setIdade(48);
		contato.setDataCadastro(new Date());
		
//		contatoDAO.save(contato);
		
		for (Contato c : contatoDAO.getContatos()) {
			System.out.println("Contato: "+ c.getNome() + " | " + c.getIdade() + " | " + c.getDataCadastro());
		}
		
	}
}
