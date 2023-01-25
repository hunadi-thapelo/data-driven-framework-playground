import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class dataDriven {


    public ArrayList<String> getData(String testcaseName) throws IOException {

        ArrayList<String> ar = new ArrayList<>();
        FileInputStream fis = new FileInputStream("/Users/hunadimapulane/DemoDocs/ddtDemo.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis); //accepts file input stream argument
        int sheets = workbook.getNumberOfSheets(); //to get count of sheets in excel doc

        for (int i = 0; i < sheets; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase("Testcases")) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                String wrkSheetName = sheet.getSheetName();
                System.out.println(wrkSheetName);
                //get specific row
                Iterator<Row> rows = sheet.iterator();
                Row firstRow = rows.next();
                //get specific cell
                Iterator<Cell> getCell = firstRow.cellIterator();
                int colPosition = 0;
                int columnIndex = 0;

                while (getCell.hasNext()) //checks if cell has next but won't move
                {
                    //System.out.println(colPosition);
                    Cell value = getCell.next(); //use .next() to move to cell
                    if (value.getStringCellValue().equalsIgnoreCase("testcases")) {
                        //action retrieve data
                        columnIndex = colPosition;
                        //colPosition++;
                    }
                    colPosition++;
                }
                System.out.println(columnIndex);

                while (rows.hasNext()) {
                    Row r = rows.next();
                    if (r.getCell(columnIndex).getStringCellValue().equalsIgnoreCase(testcaseName)) {
                        Iterator<Cell> cv = r.cellIterator();
                        while (cv.hasNext()) {

                            Cell cl = cv.next();
                            if(cl.getCellType()== CellType.STRING){
                                ar.add(cl.getStringCellValue());
                            }else
                            {
                                ar.add(NumberToTextConverter.toText(cl.getNumericCellValue()));
                                //ar.add(String.valueOf(cl.getNumericCellValue())); //does not work: converts numeric to double e.g 220.0
                            }


                        }
                    }

                }
            }
        }
        return ar; }

    public static void main(String[] args) {
    }
}