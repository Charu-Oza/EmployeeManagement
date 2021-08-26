


import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class To_Excel {
	
	public static void main(String[] args) {
	
		try {
			
			Document doc = Jsoup.connect("http://localhost:8012/OJT_Task_5/").get();
			Elements rowelements = doc.getElementsByTag("tr");
			
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("Data");
			
			int rowno=0;
			int cellno=0;
			
			for(int i=1 ; i<rowelements.size() ; i++){
				
				Element dataelements = rowelements.get(i);
				Elements data = dataelements.select("td");
				XSSFRow row = sheet.createRow(rowno);
				cellno=0;
				
				for(int j=0; j<data.size() ;j++){
					
					Cell cell = row.createCell(cellno);
					cell.setCellValue(data.get(j).text());
					System.out.println(data.get(j).text());
					cellno++;
				}
				
				rowno++;
						
			}
						
			workbook.write(new FileOutputStream(new File("Data1.xls")));
			workbook.close();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}



