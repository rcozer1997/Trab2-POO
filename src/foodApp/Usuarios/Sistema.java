package foodApp.Usuarios;
import java.util.ArrayList;
import java.util.Scanner;
import foodApp.Acesso;
import foodApp.Arquivos;
import foodApp.Menus;

public class Sistema {
	ArrayList<Usuario> listaUsuarios = new ArrayList<>();
	
	public void menuPrincipal() {
		Acesso acesso = new Acesso();
		Menus menus = new Menus();
		Arquivos arq = new Arquivos();
		Scanner s = new Scanner(System.in);
		
		arq.lerUsuariosArq(listaUsuarios);
		
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
				if(!acesso.verificaCadastro(a, listaUsuarios)) break;
				listaUsuarios.add(a);
				arq.salvaUsuariosArq(listaUsuarios, "Usuarios.csv");
				break;
			case 2:
				Proprietario p = new Proprietario();
				if(!acesso.verificaCadastro(p, listaUsuarios)) break;
				listaUsuarios.add(p);
				arq.salvaUsuariosArq(listaUsuarios, "Usuarios.csv");
				listaUsuarios.isEmpty();
				break;
			case 3:
				Cliente c = new Cliente();
				if(!acesso.verificaCadastro(c, listaUsuarios)) break;
				listaUsuarios.add(c);
				arq.salvaUsuariosArq(listaUsuarios, "Usuarios.csv");
				break;
			
			} 
		}
		else if(opcao == 2) {
			acesso.login(listaUsuarios);
		}
		else
			System.out.println("Opcao invalida!!!");
	
	}while (opcao!= 0);
}	
	void removerCadastro(String email) {
		Arquivos arq = new Arquivos();
		Scanner s = new Scanner(System.in);
		
		for(int i = 0; i<listaUsuarios.size();i++){
			Usuario u = listaUsuarios.get(i);
			if(u.getEmail().equals(email)){
				System.out.println("Tem certeza que deseja remover o cadastro?");
				System.out.println("1 - Sim\n2 - Nao");
				int opcao = s.nextInt();
				
				if(opcao == 1) {
					listaUsuarios.remove(u);
			        System.out.println("Cliente removido!");
					arq.salvaUsuariosArq(listaUsuarios, "Usuarios.csv");
					break;
				}
				else if(opcao == 2) {
					break;
				}			
			}
		}	
	}	
}
