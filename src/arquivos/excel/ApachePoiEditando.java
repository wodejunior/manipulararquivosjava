package arquivos.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoiEditando {
	
	public static void main(String[] args) throws Exception {
		
		File file = new File("C:\\Users\\wodej\\eclipse-workspace\\Arquivos\\src\\arquivos\\excel\\arquivo_excel.xls");
		
		FileInputStream entrada = new FileInputStream(file);
		
		HSSFWorkbook hssfWorkBook = new HSSFWorkbook(entrada);
		HSSFSheet planilha = hssfWorkBook.getSheetAt(0); 
		
		Iterator<Row> linhaIterator = planilha.iterator();
		
		while( linhaIterator.hasNext() ) {
			Row linha = linhaIterator.next(); //Percorre dados da pessoa na linha.
			
			int numeroCelulas = linha.getPhysicalNumberOfCells();
			
			Cell cell = linha.createCell(numeroCelulas);
			cell.setCellValue("5.487,20");
		}
		
		entrada.close();
		
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkBook.write(saida);
		saida.flush();
		saida.close();
		
		System.out.println("Planilha atualizada");
	}
}
