import java.util.Scanner;
import java.io.*;
import java.util.ArrayList
;
public class Main {
	static Scanner sc = new Scanner(System.in);
	
	public static void criarDisciplina() {
		int i = 1;
		while( i == 1) {
				System.out.println("Digite o nome da disciplina: ");
				String disciplina = sc.next();
			

				try {
					File diretorio = new File("disciplinas");
					diretorio.mkdir();
					
					File diretorioGabarito = new File("gabaritos");
					diretorioGabarito.mkdir();
					
					File arquivoGabarito = new File(diretorioGabarito, disciplina + "Gabarito" + ".txt");
					FileWriter fwGabarito = new FileWriter(arquivoGabarito, true);
					BufferedWriter bwGabarito = new BufferedWriter(fwGabarito);
					
					File arquivo = new File(diretorio, disciplina + ".txt");
					FileWriter fw = new FileWriter(arquivo, true);
					BufferedWriter bw = new BufferedWriter(fw);
					
					System.out.println("Digite o gabarito de " + disciplina + ": ");
					String gabarito = sc.next();	
					bwGabarito.write(gabarito);
					System.out.println("\nO gabarito está salvo em: gabaritos/"+ disciplina + "Gabarito.txt\n" );
					bwGabarito.close();
					fwGabarito.close();
					
					int iLinha = 1;
					while(iLinha==1) {
						System.out.println("Digite o nome do aluno: ");
						String aluno = sc.next();
						System.out.println("Digite a sequencia de V ou F do " + aluno + ": ");
						String respostas = sc.next();
						
						bw.write(respostas);
						bw.write("	");
						bw.write(aluno);
						bw.newLine();
						
						System.out.println("Deseja adicionar outro aluno?\n 1-sim 0-não");
						iLinha = sc.nextInt();
						if(iLinha == 0) {
							bw.close();
							fw.close();
						}
					}
					 
				} catch (IOException e) {
					System.out.println("Erro");
				}
				System.out.println("Deseja adicionar outra disciplina?\n 1-sim 0-não");
				i = sc.nextInt();
				
			}
		}
	
	public static void verDisciplina(){
		File file = new File("disciplinas");
		File[] disciplinas = file.listFiles();
		for (File fileTmp : disciplinas) {
		     System.out.println(fileTmp.getName());
		   }
	}
	
	public static void main(String[] args) {
		
		int i = 1;
		while(i == 1) {
			System.out.println("****** O que deseja fazer? ******");
			System.out.println("Criar disciplina-1");
			System.out.println("Ver disciplinas-2");
			
			i = sc.nextInt();
			switch(i) {
				case 1:
					criarDisciplina();
				case 2:
					verDisciplina();
	
			}
			
		}
		
	}
}
