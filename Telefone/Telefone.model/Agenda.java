 package Telefone.model;

import java.util.Arrays;

public class Agenda{
	private Contatos[] contatos;
	
	public Agenda() {
		this.contatos = new Contatos[25000];
	}
	
	public Agenda(int tamanho) {
		this.contatos = new Contatos[tamanho];
	}
	
	public void addContato(Contatos c) {		
		if(existeContato(c)) {
			System.out.println("O contato com esse nome já existe");
		}else if(agendaCheia()) {
			System.out.println("Agenda cheia. Elimine um contato para adicionar um novo.");
		}else {
			boolean buscar = false;
			for(int i = 0;i<contatos.length && !buscar;i++) {
				if(contatos[i] == null) {
					contatos[i] = c;
					buscar = true;

				}

			}
			if(buscar) {
				System.out.println("Número salvo");
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
			System.out.println("Contato não encontrado");
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
			System.out.println("Contato não pode ser eliminado pois não existe.");
		}else {
			System.out.println("Contato "+c.getNome()+" eliminado");
		}
	}
	public boolean agendaCheia() {
		for(int i=0;i<contatos.length;i++) {
			if(contatos[i] == null) {
				return false;
			}
		}
		return true;
	}
	
	public int contatosLivres() {
		int contadorL=0;
		for(int i=0;i<contatos.length;i++) {
			if(contatos[i]==null) {
				contadorL++;
			}
		}
		return contadorL;
	}
}
