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
				loginProprietario();
				break;
			case 3:
				
				break;
			
			} 
		}
		else
			System.out.println("Opcao invalida!!!");
	
	}while (opcao!= 0);
}	
	
	//Nesse método, optei por iterar as 3 listas pois acredito que na lógica de negócio, seria incorreto que, por exemplo, um Administrador pudesse cadastrar com o mesmo email que um Usuario cadastrou.
	//Embora sejam usuarios de tipos diferentes, pensando numa regra geral, isso seria considerado um vazamento de segurança. Iterando dessa forma, garanto que isso não aconteça.
	public void verificaCadastro(Usuario u) {
		for(int i = 0; i<listaProprietarios.size();i++){
			Usuario usu = listaProprietarios.get(i);
			if(usu.getEmail().equals(u.getEmail()))
			{
				System.out.println("Email ja cadastrado!");
				break;
			}	
		}
		for(int i = 0; i<listaClientes.size();i++){
			Usuario usu = listaClientes.get(i);
			if(usu.getEmail().equals(u.getEmail()))
			{
				System.out.println("Email ja cadastrado!");
				break;
			}		
		}
		for(int i = 0; i<listaAdmins.size();i++){
			Usuario usu = listaAdmins.get(i);
			if(usu.getEmail().equals(u.getEmail()))
			{
				System.out.println("Email ja cadastrado!");
				break;
			}		
		}
	}
	
	public void loginProprietario(){
		
		Scanner s = new Scanner(System.in);
		System.out.print("Email:");
		String email = s.nextLine();
		System.out.print("Senha:");
		String senha = s.nextLine();

		Proprietario prop = null;
		for(int i = 0; i<listaProprietarios.size();i++){
			Proprietario p = listaProprietarios.get(i);
			if(p.getEmail().equals(email)){
				prop = p;
				validaSenha(prop, senha);
				break;
			}
		}	
		if(prop == null){
			System.out.println("Proprietario nao existe!");
		}
		
	}
	
	
	
	public void validaSenha(Usuario u, String senha){
		if(u.getSenha().equals(senha)){
			 System.out.println("Logado com sucesso!");
			 u.menu();
		}
		else {
			System.out.println("Senha incorreta!");
			}
	}
	
}
