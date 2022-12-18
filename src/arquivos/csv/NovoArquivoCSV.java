package arquivos.csv;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import arquivos.Pessoa;

public class NovoArquivoCSV {
	
	public static void main(String[] args) throws IOException  {
	
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setNome("Joao da Silva");
		pessoa1.setEmail("joaosilva@gmail.com");
		pessoa1.setIdade(23);
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setNome("Marina Carneiro");
		pessoa2.setEmail("marinacarneiro@gmail.com");
		pessoa2.setIdade(26);
		
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setNome("Adebaldo Cristi");
		pessoa3.setEmail("adebaldocristi@gmail.com");
		pessoa3.setIdade(44);
		
		Pessoa pessoa4 = new Pessoa();
		pessoa4.setNome("Lois Lane");
		pessoa4.setEmail("loislane@gmail.com");
		pessoa4.setIdade(78);
		
		Pessoa pessoa5 = new Pessoa();
		pessoa5.setNome("Bruce Wayne");
		pessoa5.setEmail("brucewayne@gmail.com");
		pessoa5.setIdade(24);
		
		Pessoa pessoa6 = new Pessoa();
		pessoa6.setNome("Galvao Bueno");
		pessoa6.setEmail("galvaobueno@gmail.com");
		pessoa6.setIdade(68);
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		pessoas.add(pessoa4);
		pessoas.add(pessoa5);
		pessoas.add(pessoa6);
		
		File arquivo = new File("C:\\Users\\wodej\\eclipse-workspace\\Arquivos\\src\\arquivos\\csv\\arquivo.csv");
		
		if( !arquivo.exists() ) {
			arquivo.createNewFile();
		}
		
		FileWriter escrever_no_arquivo = new FileWriter(arquivo);
		
		//escrever_no_arquivo.write("Meu texto do arquivo " + "\n");
		//escrever_no_arquivo.write("Minha segunda linha"+ "\n");
		
		/*
		for(int i = 1; i <= 10; i++) {
			escrever_no_arquivo.write("Texto da minha linha: " + i + "\n");	
		}
		*/
		for (Pessoa p : pessoas) {
			escrever_no_arquivo.write(p.getNome() + ";" + p.getEmail() + ";" + p.getIdade() + "\n");
		}
		
		escrever_no_arquivo.flush();
		escrever_no_arquivo.close();
	}

}
