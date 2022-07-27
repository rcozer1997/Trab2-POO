package foodApp.Usuarios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public abstract class Usuario {
	String nome;
	String email;
	String senha;
	

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
	
	public Usuario(BufferedReader b) {
		try {
		this.nome = b.readLine();
		this.email = b.readLine();
		this.senha = b.readLine();
		}catch(IOException e) 
		{
			System.out.println("Erro");
		}
	}
	
	public void salvarUsuariosArq(BufferedWriter b) throws IOException {
		b.write(this.nome + "\n");
		b.write(this.email + "\n");
		b.write(this.senha + "\n");
	}
	
	
	public void login() {
		Scanner s = new Scanner (System.in);
		System.out.println("Email:");
		String email = s.nextLine();
		System.out.println("Senha:");
		String senha = s.nextLine();
		
		//validaLogin(email, senha);		
	}

	public String getEmail(){
		return this.email;
	}

		/*
	public boolean validaLogin(File f, String email, String senha) {
		try {
			Scanner s = new Scanner(f);
			while (s.hasNextLine()) {
				if()
			}
			s.close();
		
		}catch(IOException e) {
			System.out.println("Erro");
		}
		
		
		
		
		
		if(email.equals(this.email) && senha.equals(this.senha)) {
			System.out.println("Logado com sucesso!");
			return true;
		}
		else
			System.out.println("Erro no login! Confira seus dados novamente.");
		return false;
	}
	*/
	
	public abstract void removeCadastro();
	
	
}
