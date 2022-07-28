package foodApp.Usuarios;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;

import foodApp.Arquivos;
import foodApp.Lanchonetes.Lanchonete;

public class Proprietario extends Usuario {
	ArrayList<Lanchonete> lanchonetes = new ArrayList <>();
	Arquivos arq = new Arquivos();
	
	public Proprietario() {
		super();
	}

	public Proprietario(BufferedReader b) {
		super(b);
	}

	public void menu() {
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
			cadastraLanchonete();
			arq.salvaLanchoneteArq(lanchonetes);
			break;
			
		}
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
		
		Lanchonete l = new Lanchonete(codigo,nome,endereco,categoria);
		
		lanchonetes.add(l);
	}
	
	public void removeLanchonete() {
		
	}
	
	}
	
	
	
	
	
	
