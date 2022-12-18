package arquivos.excel;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import arquivos.Pessoa;

public class LerArquivoExcel {

	public static void main(String[] args) throws Exception {
		
		FileInputStream entrada = new FileInputStream(new File("C:\\Users\\wodej\\eclipse-workspace\\Arquivos\\src\\arquivos\\excel\\arquivo_excel.xls") );
		
		HSSFWorkbook hssfWorkBook = new HSSFWorkbook(entrada);
		HSSFSheet planilha = hssfWorkBook.getSheetAt(0); //Pega a primeira planilha do arquivo excel
		
		Iterator<Row> linhaIterator = planilha.iterator();
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		while( linhaIterator.hasNext() ) { //Enquanto houver registro no arquivo excel
			
			Row linha = linhaIterator.next(); //Percorre dados da pessoa na linha.
			Iterator<Cell> celulas = linha.iterator(); //Percorre dados da celula
			
			
			Pessoa pessoa = new Pessoa();
			
			while( celulas.hasNext() ) { //Enquanto houver registro na celula
				 
				Cell cell = celulas.next();
				
				switch( cell.getColumnIndex() ) {
				case 0:
					pessoa.setNome( cell.getStringCellValue() );
					break;
				case 1:
					pessoa.setEmail( cell.getStringCellValue() );
					break;
				case 2:
					pessoa.setIdade( Double.valueOf(cell.getNumericCellValue()).intValue() );
					break;
				}
			}
			
			pessoas.add(pessoa);
		}
		
		entrada.close();
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa);
		}
		
	}

}
