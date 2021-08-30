 package Telefone.model;

import java.util.Arrays;

public class Agenda {
	private Contatos[] contatos;
	
	public Agenda() {
		this.contatos = new Contatos[10];
	}
	
	public Agenda(int tamanho) {
		this.contatos = new Contatos[tamanho];
	}
	
	public void addContato(Contatos c) {		
		if(existeContato(c)) {
			System.out.println("O contato com esse nome j� existe");
		}else {
			boolean buscar = false;
			for(int i = 0;i<contatos.length && !buscar;i++) {
				if(contatos[i] == null) {
					contatos[i] = c;
					buscar = true;
					
				}
				
			}
			if(buscar) {
				System.out.println("N�mero salvo");
			}
			
		}
	}
	

	public boolean existeContato(Contatos c) {
		boolean buscar = false;		
		for(int i=0;i<contatos.length;i++) {			
			if(contatos[i]!=null && c.equals(contatos[i])) {			
				return true;
			}
		}
		return false;
	}


	public void listarContatos(){
		for(int i=0;i<contatos.length;i++) {
			if(contatos[i]!=null) {
				System.out.println(contatos[i]);
			}
		}
	}
	
	public void buscarContatoPorNome(String nome) {		
		boolean buscar = false;
		for(int i=0;i<contatos.length && !buscar;i++) {
			if(contatos[i]!=null && contatos[i].getNome().equalsIgnoreCase(nome)) {
				System.out.println(contatos[i].toString());
				buscar = true;
			}
		}
		if(!buscar) {
			System.out.println("Contato n�o encontrado");
		}
	}
	
	public void eliminarContato(Contatos c) {
		boolean buscar = false;
		for(int i=0;i<contatos.length && !buscar;i++) {
			if(contatos[i]!=null && contatos[i].equals(c)) {
				contatos[i]=null;
				buscar=true;
			}
		}
		if(!buscar) {
			System.out.println("Contato n�o pode ser eliminado pois n�o existe.");
		}else {
			System.out.println("Contato "+c.getNome()+" eliminado");
		}
	}
}