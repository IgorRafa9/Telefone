package Telefone.model;

public class Contatos {
	private String nome;
	private int cod_tel;
	private int tel;
	
	
	public Contatos(String nome, int cod_tel, int tel) {
		this.nome = nome;
		this.cod_tel = cod_tel;
		this.tel = tel;
	}
	public Contatos(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getCod_tel() {
		return cod_tel;
	}


	public void setCod_tel(int cod_tel) {
		this.cod_tel = cod_tel;
	}


	public int getTel() {
		return tel;
	}


	public void setTel(int tel) {		
		this.tel = tel;		
	}

	public boolean duplicado(Contatos c) {
		if(this.nome.equalsIgnoreCase(c.getNome())) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + "\nTelefone: (" + cod_tel + ")"+tel+"\n============================";
	}

	/*@Override
	public boolean equals(Object obj) {
		if(obj==null) {
			return false;
		}
		
		if(obj.getClass()!=this.getClass()) {
			return false;
		}
		
		final Contatos other = (Contatos) obj;
		if((this.nome == null) ? (other.nome != null): !this .nome.equals(other.nome)) {
			return false;
		}
		
		if(this.cod_tel != other.cod_tel) {
			return false;
		}
		
		return true;
		
		
	}*/
	
	public boolean equals(Contatos c) {
		if(this.nome.trim().equalsIgnoreCase(c.getNome().trim())) {
			return true;
		}
		return false;
	}
	
	
	
}
