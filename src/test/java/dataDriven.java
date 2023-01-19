import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class dataDriven {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("/Users/hunadimapulane/DemoDocs/ddtDemo.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis); //accepts file input stream argument

        int sheets = workbook.getNumberOfSheets(); //to get count of sheets in excel doc

        for(int i =0; i<sheets; i++)
        {
            if(workbook.getSheetName(i).equalsIgnoreCase("testcases")) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                //get specific row
                Iterator<Row> rows = sheet.iterator();
                Row firstRow = rows.next();
                //get specific cell
                Iterator<Cell> getCell = firstRow.cellIterator();
                while(getCell.hasNext()) //checks if cell has next but won't move
                {
                    Cell value = getCell.next(); //use .next() to move to cell
                    if(value.getStringCellValue().equalsIgnoreCase("testcases"));
                    {
                        //action retrieve data
                    }

                }
            }
        }
    }
}
