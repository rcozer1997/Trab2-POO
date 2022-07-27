package foodApp.Usuarios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import foodApp.Arquivos;
import foodApp.Menus;

public class Sistema {
	ArrayList<Proprietario> listaProprietarios = new ArrayList<>();
	ArrayList<Cliente> listaClientes = new ArrayList<>();
	ArrayList<Administrador> listaAdmins = new ArrayList<>();
	
	
	public void menuPrincipal() {
		
		Menus menus = new Menus();
		Arquivos arq = new Arquivos();
		Scanner s = new Scanner(System.in);
		arq.lerClientesArq(listaClientes);
		arq.lerProprietarioArq(listaProprietarios);	
		arq.lerAdminsArq(listaAdmins);
		
		System.out.println(listaClientes.isEmpty());
		int opcao;
		do {
			menus.menuPrincipal();
		opcao = s.nextInt();
		
		if(opcao == 1) {
			
			System.out.println("Qual perfil deseja cadastrar?");
			menus.printaPerfisUsuarios();
;
			
			int opcaoCadastro = s.nextInt();
			
			switch(opcaoCadastro) {
			case 1:
				Administrador a = new Administrador();
				listaAdmins.add(a);
				arq.salvaAdminArq(listaAdmins, "Admins.csv");
				break;
			case 2:
				Proprietario p = new Proprietario();
				listaProprietarios.add(p);
				arq.salvaProprietarioArq(listaProprietarios, "Proprietarios.csv");
				break;
			case 3:
				Cliente c = new Cliente();
				listaClientes.add(c);
				arq.salvaClienteArq(listaClientes, "Clientes.csv");
				break;
			
			} 
		}
		else if(opcao == 2) {
			System.out.println("Deseja logar em qual sistema?");
			menus.printaPerfisUsuarios();
			int opcaoLogin = s.nextInt();
			
			switch(opcaoLogin) {
			case 1:
				
				break;
			case 2:
				
				menus.menuProprietario();
				break;
			case 3:
				
				break;
			
			} 
		}
		else
			System.out.println("Opcao invalida!!!");
	
	}while (opcao!= 0);
}
	
	
}
