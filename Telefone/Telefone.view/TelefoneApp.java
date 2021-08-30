package Telefone.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

import Telefone.model.Contatos;
import Telefone.model.Agenda;

public class TelefoneApp {

	public static void main(String[] args) throws IOException {
		Scanner key = new Scanner (System.in);
		
		var buffreader = new BufferedReader(new InputStreamReader(System.in));
		
		boolean sair = false;	
		int opc;
		int tel,cod_tel;
		String name,resp;
		
		Agenda agenda = new Agenda(3);
		Contatos c;		
		while(!sair) {
		
		try {
			do {
			System.out.println("1 - Adicionar contato");
			System.out.println("2 - Listar contatos");
			System.out.println("3 - Buscar contato");
			System.out.println("4 - Existe contato");
			System.out.println("5 - Eliminar contato");
			System.out.println("6 - Sair");
			
				System.out.println("Escreva um das opções");
				opc = key.nextInt();
				
				switch (opc) {
					case 1:
						System.out.println("Nome: ");
						name = buffreader.readLine();
						
						System.out.println("DDD: ");
						cod_tel = key.nextInt();
						
						System.out.println("Telefone: ");
						tel = key.nextInt();					

						c = new Contatos(name, cod_tel, tel);
					    
						agenda.addContato(c);
			
						break;
					case 2:
						agenda.listarContatos();						
						break;
					case 3:
						System.out.println("Nome: ");
						name = buffreader.readLine();
						
						try {
							agenda.buscarContatoPorNome(name);
							
						}catch (Exception e) {
							throw new NullPointerException("Não existe esse contato");
						}
						System.out.println("==========================================");
						break;
						
					case 4:
						System.out.println("Nome: ");
						name = buffreader.readLine();	
						
						c=new Contatos(name,0,0);
						
						if(agenda.existeContato(c)){
							System.out.println("Contato existe");
							System.out.println("==========================================");
						}else {
							System.out.println("Contato não existe");
							System.out.println("==========================================");
						}
						
						break;
					case 5:
						System.out.println("Nome: ");
						name = buffreader.readLine();
						
						c=new Contatos(name,0,0);
						
						agenda.eliminarContato(c);
						System.out.println("==========================================");
						break;
					case 6:
						sair = true;
						break;
					default:
						System.out.println("Apenas números entre 1 e 5");
					}
				System.out.println("Mais alguma coisa?");
				resp = buffreader.readLine();
				System.out.println("==========================================");
			}while(resp.equalsIgnoreCase("s"));
			key.close();
			System.out.println("Saiu");
			}catch(InputMismatchException e) {
				System.out.println("Insira o número: ");
				key.next();
			}
		
		}
	}
}
