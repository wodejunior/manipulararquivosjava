package arquivos.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import arquivos.Pessoa;

public class ApachePoi {

	public static void main(String[] args) throws IOException {
		
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
		
		Pessoa pessoa7 = new Pessoa();
		pessoa7.setNome("Alberto Roberto");
		pessoa7.setEmail("albertoroberto@gmail.com");
		pessoa7.setIdade(102);
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		pessoas.add(pessoa4);
		pessoas.add(pessoa5);
		pessoas.add(pessoa6);
		pessoas.add(pessoa7);
		
		File file = new File("C:\\Users\\wodej\\eclipse-workspace\\Arquivos\\src\\arquivos\\excel\\arquivo_excel.xls");
		
		if( !file.exists() ) {
			file.createNewFile();
		}
		
		HSSFWorkbook hssfWorkBook = new HSSFWorkbook(); //É utilizado para escrever na planilha.
		HSSFSheet linhasPessoa = hssfWorkBook.createSheet("Planilha_Pessoa"); //Criar a planilha.
		
		int numeroLinha = 0;
		for (Pessoa p : pessoas) {
			Row linha = linhasPessoa.createRow(numeroLinha ++); //Criando a linha na planilha.
			
			int celula = 0;
			Cell celNome = linha.createCell(celula ++);
			celNome.setCellValue(p.getNome());
			
			Cell celEmail = linha.createCell(celula ++);
			celEmail.setCellValue(p.getEmail());
			
			Cell celIdade = linha.createCell(celula ++);
			celIdade.setCellValue(p.getIdade());
		}
		
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkBook.write(saida); //Escreve na planilha em arquivo.
		saida.flush();
		saida.close();
		
		System.out.println("Planilha foi criada!");
		
	}
}
