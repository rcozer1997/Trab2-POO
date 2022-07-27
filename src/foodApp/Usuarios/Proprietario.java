package foodApp.Usuarios;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;

import foodApp.Interfaces.Login;
import foodApp.Lanchonetes.Lanchonete;

public class Proprietario extends Usuario implements Login {
	

	public Proprietario(BufferedReader b) {
		super(b);
		// TODO Auto-generated constructor stub
	}
	
	public Proprietario() {
		super();
		
	}

	ArrayList<Lanchonete> lanchonetes = new ArrayList <>();

	
	@Override
	public void removeCadastro() {
		// TODO Auto-generated method stub
		
	}




	}
	
	
	
	
	
	
