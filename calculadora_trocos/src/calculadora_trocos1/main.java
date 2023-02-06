package calculadora_trocos1;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double valor = 0;
		
		int nota100 = 0;
		int nota50 = 0;
		int nota20 = 0;
		int nota10 = 0;
		int nota5 = 0;
		int nota2 = 0;
		int moeda1 = 0;
		int moeda050 = 0;
		int moeda025 = 0;
		int moeda010 = 0;
		int moeda05 = 0;
		int moeda01 = 0;
		
		int res = 0;
		
		do {
			System.out.println("\n\n<====| Calculadora de Trocos |====>");
			
			System.out.print("\nDigite o valor da compra: ");
			double valor_compra = Double.parseDouble(sc.nextLine());
			
			System.out.print("Digite o valor recebido: ");
			double valor_recebido = Double.parseDouble(sc.nextLine());
			
			if ( valor_compra >= valor_recebido) {
				System.out.println("\nNão é necessário um troco!");
			} else {
				valor = valor_recebido - valor_compra;
				
				double troco = valor;
				
				nota100 = (int) (valor / 100);
				valor = valor % 100.0;
				
				nota50 = (int) (valor / 50);
				valor = valor % 50.0;
				
				nota20 = (int) (valor / 25);
				valor = valor % 25.0;
				
				nota10 = (int) (valor / 10);
				valor = valor % 10.0;
				
				nota5 = (int) (valor / 5);
				valor = valor % 5.0;
				
				nota2 = (int) (valor / 2);
				valor = valor % 2.0;
				
				moeda1 = (int) (valor / 1);
				valor = valor % 1.0;
				
				moeda050 = (int) (valor / 0.5);
				valor = valor % 0.5;
				
				moeda025 = (int) (valor / 0.25);
				valor = valor % 0.25;
				
				moeda010 = (int) (valor / 0.1);
				valor = valor % 0.1;
				
				moeda05 = (int) (valor / 0.05);
				valor = valor % 0.05;
				
				moeda01 = (int) (valor / 0.01);
				valor = valor % 0.01;
				
				System.out.println("\nO troco será de: " + troco + "R$");
				System.out.println(nota100 + " nota(s) de 100R$");
				System.out.println(nota50 + " nota(s) de 50R$");
				System.out.println(nota20 + " nota(s) de 20R$");
				System.out.println(nota10 + " nota(s) de 10R$");
				System.out.println(nota5 + " nota(s) de 5R$");
				System.out.println(nota2 + " nota(s) de 2R$");
				System.out.println(moeda1 + " moeda(s) de 1R$");
				System.out.println(moeda050 + " moeda(s) de 0.50R$");
				System.out.println(moeda025 + " moeda(s) de 0.25R$");
				System.out.println(moeda010 + " moeda(s) de 0.10R$");
				System.out.println(moeda05 + " moeda(s) de 0.05R$");
				System.out.println(moeda01 + " moeda(s) de 0.01R$");
			}
			
			System.out.print("\nDeseja calcular um novo troco [1|sim 0|nao]: ");
			res = Integer.parseInt(sc.nextLine());
			
		} while (res != 0);
		
		System.out.print("Adeus!!!");
	}
}