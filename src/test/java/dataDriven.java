import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class dataDriven {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("/Users/hunadimapulane/DemoDocs/ddtDemo.xlxs");
        XSSFWorkbook workbook = new XSSFWorkbook(fis); //accepts file input stream argument

        int sheets = workbook.getNumberOfSheets(); //to get count of sheets in excel doc

        for(int i =0; i<sheets; i++)
        {
            if(workbook.getSheetName(i).equalsIgnoreCase("testcases")) {
                XSSFSheet sheet = workbook.getSheetAt(i);
            }


        }


    }
}
