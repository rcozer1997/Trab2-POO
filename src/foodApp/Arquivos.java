package foodApp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import foodApp.Usuarios.Administrador;
import foodApp.Usuarios.Cliente;
import foodApp.Usuarios.Proprietario;
import foodApp.Usuarios.Usuario;

public class Arquivos {
	
	public void salvaProprietarioArq(ArrayList<Proprietario> listaProprietarios, String fileName) {
		try {
			FileWriter f = new FileWriter(fileName);
			BufferedWriter b = new BufferedWriter(f);
			
			b.write(listaProprietarios.size() + "\n");
			for(Proprietario p : listaProprietarios) {
				
				p.salvarUsuariosArq(b);
			}
			b.close();
			
		}catch(IOException e) {
			System.out.println("Erro ao salvar o arquivo.");
		}
	}
	
	public void salvaClienteArq(ArrayList<Cliente> listaClientes, String fileName) {
		try {
			FileWriter f = new FileWriter(fileName);
			BufferedWriter b = new BufferedWriter(f);
		
			b.write(listaClientes.size() + "\n");
			for(Cliente c : listaClientes) {
				
				c.salvarUsuariosArq(b);
			}
			b.close();
			
		}catch(IOException e) {
			System.out.println("Erro ao salvar o arquivo.");
		}
	}
		
	public void salvaAdminArq(ArrayList<Administrador> listaAdmins, String fileName) {
		try {
			FileWriter f = new FileWriter(fileName);
			BufferedWriter b = new BufferedWriter(f);
			
			b.write(listaAdmins.size() + "\n");
			for(Administrador a : listaAdmins) {
				
				a.salvarUsuariosArq(b);
			}
			b.close();
			
		}catch(IOException e) {
			System.out.println("Erro ao salvar o arquivo.");
		}
	}
	
	public void lerProprietarioArq(ArrayList<Proprietario> listaProprietarios) {
		try {
			FileReader f = new FileReader("Proprietarios.csv");
			BufferedReader b = new BufferedReader(f);
			
			int t = Integer.parseInt(b.readLine());
			
			for(int i = 0; i<t; i++) {
				listaProprietarios.add(new Proprietario(b));
			}
			
			b.close();
			f.close();
			System.out.println(listaProprietarios.size() + " Proprietarios carregados!");
			
		}catch(IOException e) {
			System.out.println("Nenhum proprietario carregado.");
		}
	}
	
	public void lerClientesArq(ArrayList<Cliente> listaClientes) {
		try {
			FileReader f = new FileReader("Proprietarios.csv");
			BufferedReader b = new BufferedReader(f);
			
			int t = Integer.parseInt(b.readLine());
			
			for(int i = 0; i<t; i++) {
				listaClientes.add(new Cliente(b));
			}
			b.close();
			System.out.println(listaClientes.size() + " Clientes carregados!");
			
		}catch(IOException e) {
			System.out.println("Nenhum cliente carregado.");
		}
	}
	
	public void lerAdminsArq(ArrayList<Administrador> listaAdmins) {
		try {
			FileReader f = new FileReader("Proprietarios.csv");
			BufferedReader b = new BufferedReader(f);
			
			int t = Integer.parseInt(b.readLine());
			
			for(int i = 0; i<t; i++) {
				listaAdmins.add(new Administrador(b));
			}
			f.close();
			b.close();
			System.out.println(listaAdmins.size() + " Administradores carregados!");
			
		}catch(IOException e) {
			System.out.println("Nenhum admin carregado.");
		}
	}

	
	
	
	
}