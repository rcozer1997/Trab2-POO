package foodApp.Usuarios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Usuario {
	String nome;
	String email;
	String senha;
	int ident; // 1 - Administrador , 2 - Proprietario , 3 - Cliente
	public Usuario() {
		Scanner s = new Scanner(System.in);
		System.out.print("Nome:");
		String nome = s.nextLine();
		System.out.print("Email:");
		String email = s.nextLine();
		System.out.print("Senha:");
		String senha = s.nextLine(); 
		
		this.nome = nome;
		this.email = email;
		this.senha = senha;	
	}
	
	public Usuario(ArrayList<String> list) {	
		this.nome = list.get(0);
		this.email = list.get(1);
		this.senha = list.get(2);
		this.ident = Integer.parseInt(list.get(3));
		
	}
	
	public void gravaUsuariosArq(BufferedWriter b) throws IOException {
		b.write(this.nome + "\n");
		b.write(this.email + "\n");
		b.write(this.senha + "\n");
		b.write(this.ident + "\n");
	}

	public String getEmail(){
		return this.email;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	public String getNome() {
		return this.nome;		
	}
	
	public int getIdent() {
		return this.ident;
	}
	public abstract void menu();
	
	
	
}
