package br.com.agenda.aplicacao;

import java.sql.ResultSet;
import java.util.Date;
import java.util.Scanner;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Contato contato = new Contato();
		ContatoDAO contatoDAO = new ContatoDAO();
		
		Scanner sc = new Scanner(System.in); 
		int res = -1;
		
		do {
			System.out.println("\nBem vindo ao meu CRUD");
			System.out.println("\n[1] = CREATE\n[2] = READ\n[3] = UPDATE\n[4] = DELETE\n[0] = SAIR");
			System.out.print("\nres: ");
			
			res = Integer.parseInt(sc.nextLine());
			
			switch (res) {
				case 1: {
					
					System.out.print("\nDigite seu nome: ");
					String nome = sc.nextLine(); 
					
					System.out.print("\nDigite sua idade: ");
					int idade = Integer.parseInt(sc.nextLine());
					
					contato.setNome(nome);
					contato.setIdade(idade);
					contato.setDataCadastro(new Date());
					
					contatoDAO.save(contato);
					
					break;
				}
				case 2: {
					
					System.out.println();
					for (Contato c : contatoDAO.getContatos()) {
						System.out.println("Contato: " + c.getId() + " - " + c.getNome() + " - " + c.getIdade() + " - " + c.getDataCadastro());
					}
					
					break;
				}
				case 3: {
					
					System.out.print("\nDigite seu nome: ");
					String nome = sc.nextLine(); 
					
					System.out.print("\nDigite sua idade: ");
					int idade = Integer.parseInt(sc.nextLine());
					
					System.out.print("\nDigite seu id: ");
					int id = Integer.parseInt(sc.nextLine());
					
					contato.setNome(nome);
					contato.setIdade(idade);
					contato.setId(id);
					
					contatoDAO.update(contato);
					
					break;
				}
				case 4:
					
					System.out.print("\nDigite o id: ");
					int id = Integer.parseInt(sc.nextLine());
					
					contatoDAO.delete(id);
					
					break;
			}
			
		} while (res != 0);
		
	}
}
