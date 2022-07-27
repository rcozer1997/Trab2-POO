package foodApp.Lanchonetes;
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
	int tipo; // 1 - Lanchonete Online , 2 - Hibrida
	
	public Lanchonete(int codigo, String nome, String endereco, String categoria, int tipo) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.categoria = categoria;
		this.pontos = 0;
		this.tipo = tipo;
	}
	
	public void cadastraLanchonete() {
		Scanner s = new Scanner(System.in);

		System.out.println("Informe os dados da lanchonete a ser cadastrada: ");
		System.out.println("Codigo identificador: ");
		int codigo = s.nextInt();
		s.nextLine();
		System.out.println("Nome: ");
		String nome = s.nextLine();
		System.out.println("Endereço: ");
		String endereco = s.nextLine();
		System.out.println("Categoria de produtos: ");
		String categoria = s.nextLine();
		System.out.println("Qual o tipo da lanchonete?");
		System.out.println("1 - Online\n2 - Hibrida (contem lojas fisicas)");
		int tipo = s.nextInt();
		s.nextLine();
		
		Lanchonete l = new Lanchonete(codigo,nome,endereco,categoria, tipo);
			
	}
	
	public void removeLanchonete() {
		
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

	

