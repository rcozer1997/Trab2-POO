package foodApp.Usuarios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import foodApp.Acesso;
import foodApp.Arquivos;
import foodApp.Menus;

public class Sistema {
	ArrayList<Proprietario> listaProprietarios = new ArrayList<>();
	ArrayList<Cliente> listaClientes = new ArrayList<>();
	ArrayList<Administrador> listaAdmins = new ArrayList<>();
	
	
	public void menuPrincipal() {
		Acesso acesso = new Acesso();
		Menus menus = new Menus();
		Arquivos arq = new Arquivos();
		Scanner s = new Scanner(System.in);
		arq.lerClientesArq(listaClientes);
		arq.lerProprietarioArq(listaProprietarios);	
		arq.lerAdminsArq(listaAdmins);
		
		int opcao;
		do {
			menus.menuPrincipal();
		opcao = s.nextInt();
		
		if(opcao == 1) {
			
			System.out.println("Qual perfil deseja cadastrar?");
			menus.printaPerfisUsuarios();

			int opcaoCadastro = s.nextInt();
			
			switch(opcaoCadastro) {
			case 1:
				Administrador a = new Administrador();
				acesso.verificaCadastroAdmins(a, listaAdmins);
				break;
			case 2:
				Proprietario p = new Proprietario();
				if(!acesso.verificaCadastroProprietarios(p, listaProprietarios)) break;
				listaProprietarios.add(p);
				arq.salvaProprietarioArq(listaProprietarios, "Proprietarios.csv");
				break;
			case 3:
				Cliente c = new Cliente();
				acesso.verificaCadastroClientes(c, listaClientes);
				break;
			
			} 
		}
		else if(opcao == 2) {
			System.out.println("Deseja logar em qual sistema?");
			menus.printaPerfisUsuarios();
			int opcaoLogin = s.nextInt();
			
			switch(opcaoLogin) {
			case 1:
				acesso.loginAdmin(listaAdmins);
				break;
			case 2:		
				acesso.loginProprietario(listaProprietarios);
				break;
			case 3:
				acesso.loginCliente(listaClientes);
				break;
			
			} 
		}
		else
			System.out.println("Opcao invalida!!!");
	
	}while (opcao!= 0);
}	
	
	
	
	
	
}
