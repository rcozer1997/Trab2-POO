package foodApp;

import java.util.ArrayList;
import java.util.Scanner;

import foodApp.Usuarios.Administrador;
import foodApp.Usuarios.Cliente;
import foodApp.Usuarios.Proprietario;
import foodApp.Usuarios.Usuario;

public class Acesso {
	Arquivos arq = new Arquivos();
	public boolean verificaCadastroProprietarios(Proprietario p, ArrayList<Proprietario> listaProprietarios) {
		for(int i = 0; i<listaProprietarios.size();i++){
			Proprietario prop = listaProprietarios.get(i);
			if(prop.getEmail().equals(p.getEmail()))
			{
				System.out.println("Email ja cadastrado!");
				return false;
			}
			
		}
		return true;
	}
	
	public void verificaCadastroClientes(Cliente c, ArrayList<Cliente> listaClientes) {
		for(int i = 0; i<listaClientes.size();i++){
			Cliente cliente = listaClientes.get(i);
			if(cliente.getEmail().equals(c.getEmail()))
			{
				System.out.println("Email ja cadastrado!");
				break;
			}
			else {
				listaClientes.add(c);
				
				arq.salvaClienteArq(listaClientes, "Clientes.csv");
			}
		}
	}
	
	public void verificaCadastroAdmins(Administrador a, ArrayList<Administrador> listaAdmins) {
		for(int i = 0; i<listaAdmins.size();i++){
			Administrador admin = listaAdmins.get(i);
			if(admin.getEmail().equals(a.getEmail()))
			{
				System.out.println("Email ja cadastrado!");
				break;
			}
			else {
				listaAdmins.add(a);
				arq.salvaAdminArq(listaAdmins, "Proprietarios.csv");
			}
		}
	}
	
	public void loginProprietario(ArrayList<Proprietario>listaProprietarios){
		
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
	
	public void loginCliente(ArrayList<Cliente>listaClientes){
		
		Scanner s = new Scanner(System.in);
		System.out.print("Email:");
		String email = s.nextLine();
		System.out.print("Senha:");
		String senha = s.nextLine();

		Cliente cliente = null;
		for(int i = 0; i<listaClientes.size();i++){
			Cliente c = listaClientes.get(i);
			if(c.getEmail().equals(email)){
				cliente = c;
				validaSenha(cliente, senha);
				break;
			}
		}	
		if(cliente == null){
			System.out.println("Cliente nao existe!");
		}
		
	}
	
	public void loginAdmin(ArrayList<Administrador>listaAdmins){
	
	Scanner s = new Scanner(System.in);
	System.out.print("Email:");
	String email = s.nextLine();
	System.out.print("Senha:");
	String senha = s.nextLine();

	Administrador admin = null;
	for(int i = 0; i<listaAdmins.size();i++){
		Administrador a = listaAdmins.get(i);
		if(a.getEmail().equals(email)){
			admin = a;
			validaSenha(admin, senha);
			break;
		}
	}	
	if(admin == null){
		System.out.println("Administrador nao existe!");
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
