package foodApp.Usuarios;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;

import foodApp.Arquivos;
import foodApp.Lanchonetes.Lanchonete;

public class Proprietario extends Usuario {
	ArrayList<Lanchonete> lanchonetes = new ArrayList <>();
	Arquivos arq = new Arquivos();
	Sistema sistema = new Sistema();
	Scanner s = new Scanner(System.in);
	
	public Proprietario() {
		super();
		this.ident = 2;
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
		System.out.println("7) Remover cadastro");

		int opcao = s.nextInt();
		switch(opcao) {
		case 1:
			cadastraLanchonete();
			arq.salvaLanchoneteArq(lanchonetes);
			break;
		case 2:
			removeLanchonete();
			arq.salvaLanchoneteArq(lanchonetes);
			break;
		case 7:
			sistema.removerCadastro(this.getEmail());
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
		this.exibirLanchonetes(lanchonetes);
		System.out.print("Codigo da lanchonete a ser removida: ");
		int codigo = s.nextInt();
		Lanchonete l = buscarLanchonete(codigo);
		lanchonetes.remove(l);
	}
	
	public void exibirLanchonetes(ArrayList<Lanchonete> lanchonetes) {	
		System.out.println("---------------------------------------------------------");
		System.out.printf("%15s%20s%15s%15s%15s", "CODIGO", "NOME", "ENDERECO", "CATEGORIA", "PONTOS");
		System.out.println();
		System.out.println("---------------------------------------------------------");
		for(Lanchonete l : lanchonetes) {
			System.out.println("---------------------------------------------------------");
			System.out.format("%15s%20s%15s%15s%15s",l.codigo, l.nome, l.endereco, l.categoria, l.pontos);
			System.out.println();
			System.out.println("---------------------------------------------------------");
		}
			
	}
	
	public void cadastraLancheLanchonete() {
		exibirLanchonetes(lanchonetes);
		System.out.print("Codigo da lanchonete a cadastrar o lanche: ");
		int codigo = s.nextInt();
		Lanchonete l = buscarLanchonete(codigo);
		l.cadastraLanche(l);
	}
	
	public Lanchonete buscarLanchonete(int codigo) {
		for(Lanchonete l : lanchonetes)
			if(l.codigo == codigo)
				return l;
		return null;
	}
	
	
	
	
	
	}
	
	
	
	
	
	
