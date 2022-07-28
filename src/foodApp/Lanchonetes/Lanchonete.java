package foodApp.Lanchonetes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import foodApp.Usuarios.Proprietario;

public class Lanchonete {
	int codigo;
	String nome;
	String endereco;
	String categoria;
	int pontos;
	Proprietario proprietario;
	ArrayList<Lanche> lanches = new ArrayList<>();
	
	public Lanchonete(BufferedReader b) {
		try {
		this.codigo = Integer.parseInt(b.readLine());
		this.nome = b.readLine();
		this.endereco = b.readLine();
		this.categoria = b.readLine();
		this.pontos = Integer.parseInt(b.readLine());
		}catch(IOException e) 
		{
			System.out.println("Erro");
		}
	}
	
	public Lanchonete(int codigo, String nome, String endereco, String categoria) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.categoria = categoria;
		this.pontos = 0;
	}
	
	public void gravaLanchonete(BufferedWriter b) throws IOException {
			
			b.write(this.codigo + "\n");
			b.write(this.nome + "\n");
			b.write(this.endereco + "\n");
			b.write(this.categoria + "\n");
			b.write(this.pontos + "\n");
			
	}
	
	
	public void cadastraLancheLanchonete(Lanchonete l) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Informe os dados do lanche:");
		System.out.println("Codigo identificador: ");
		int codigo = s.nextInt();
		s.nextLine();
		System.out.println("Descricao: ");
		String descricao = s.nextLine();
		System.out.println("Preco: ");
		float preco = s.nextFloat();
		
		Lanche lanche = new Lanche(codigo,descricao, preco);
		lanches.add(lanche);
		}
}

	

