package foodApp;

import java.util.Scanner;

public class Menus {
	
	public void menuPrincipal() {
		System.out.println("------------------------------------------------");
		System.out.println("              MENU PRINCIPAL                    ");
		System.out.println("------------------------------------------------");
		System.out.println("O que deseja fazer?");
		System.out.println("1 - Cadastro");
		System.out.println("2 - Login");
	}
	public void printaPerfisUsuarios() {
		System.out.println("1 - Administrador");
		System.out.println("2 - Proprietario");
		System.out.println("3 - Cliente");
	}
	

	public void menuProprietario() {
		Scanner s = new Scanner (System.in);
		
		System.out.println("------------------------------------------------");
		System.out.println("              MENU PROPRIETARIO                 ");
		System.out.println("------------------------------------------------");
		System.out.println("1) Cadastrar Lanchonete");
		System.out.println("2) Remover Lanchonete");
		System.out.println("3) Cadastrar Lanche");
		System.out.println("4) Visualizar lista de pedidos de uma lanchonete");
		System.out.println("5) Visualizar um pedido de uma lanchonete");
		System.out.println("6) Remover pedido");
		
		int opcao = s.nextInt();
		switch(opcao) {
		case 1:
			break;
			
		}
	}

}
