import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class MainPgm {
	public static void main(String[] args) {
	try {
		Document document = Jsoup.connect("http://localhost:8012/OJT_Task_5/index.jsp").get();
		Elements rowelements = document.getElementsByTag("tr");
        System.out.println(rowelements);
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");
		PreparedStatement preparedStatement = connection.prepareStatement("insert into html1(Id,Name,City,Dept) values(?,?,?,?)");
        
		/*for(int i=1;i<rowelements.size();i++)
         {
        	 Element row=rowelements.get(i);
        	 Elements cols=row.select("td");
        	 
        	 preparedStatement.setInt(1,Integer.parseInt(cols.get(0).html()));
        	 preparedStatement.setString(2, cols.get(1).html());
        	 preparedStatement.setString(3, cols.get(2).html());
        	 preparedStatement.setString(4, cols.get(3).html());
        	 preparedStatement.execute();
         }*/
	  	for (Element rowelement : rowelements) {
			Elements dataelements = rowelement.getElementsByTag("td");
			int i = 1;
			System.out.println(dataelements);
			for (Element dataelement : dataelements) {
				preparedStatement.setString(i, dataelement.text());
				i++;

			}
			if (i > 0)
				preparedStatement.execute();
		}
		

	} catch (Exception e) {
		e.printStackTrace();
	}
}

}
