package arquivos.txt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import arquivos.Pessoa;

public class LerArquivoTxt {
	
	public static void main(String[] args) throws FileNotFoundException  {
	
		
		FileInputStream entradaArquivo = new FileInputStream(new File("C:\\\\Users\\\\wodej\\\\eclipse-workspace\\\\Arquivos\\\\src\\\\arquivos\\\\txt\\\\arquivo.txt"));
	
		Scanner lerArquivo = new Scanner(entradaArquivo, "UTF-8");
		
		try {
			List<Pessoa> pessoas = new ArrayList<Pessoa>();
			
			while ( lerArquivo.hasNext( )) {
				
				String linha = lerArquivo.nextLine();
				
				if( linha != null && !linha.isEmpty() ) {
					
					//System.out.println("Linha: "+ linha);
					
					String[] dados = linha.split("\\;");
					
					Pessoa pessoa = new Pessoa();
					pessoa.setNome(dados[0]);
					pessoa.setEmail(dados[1]);
					pessoa.setIdade(Integer.parseInt(dados[2]));
					
					pessoas.add(pessoa);
					
					System.out.println(pessoa.toString());
				}
				//System.out.println(pessoas);		
			}			
		} catch (Exception e) {
			System.out.println("Exceção: " + e);
		}
	}

}
