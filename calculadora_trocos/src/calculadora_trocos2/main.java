package calculadora_trocos2;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double valor = 0;
		
		int quantidate_notasemoedas[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		double notasemoedas[] = {100, 50, 20, 10, 5, 2, 1, 0.5, 0.25, 0.1, 0.05, 0.01};
		
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
				
				for(int i = 0; i < 12; i++) {
					quantidate_notasemoedas[i] = (int) (valor / notasemoedas[i]);
					valor = valor % notasemoedas[i];
				}
				
				System.out.println("\nO troco será de: " + troco + "R$");		
				for(int i = 0; i < 12; i++) {
					if (notasemoedas[i] <= 1.0) {
						System.out.println(quantidate_notasemoedas[i] + " moeda(s) de "+ notasemoedas[i] +"R$");
					} else {
						System.out.println(quantidate_notasemoedas[i] + " nota(s) de "+ notasemoedas[i] +"R$");
					}
				}		
			}
			
			System.out.print("\nDeseja calcular um novo troco [1|sim 0|nao]: ");
			res = Integer.parseInt(sc.nextLine());
			
		} while (res != 0);
		
		System.out.print("Adeus 2 !!!");
	}
}