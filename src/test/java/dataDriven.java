import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {

	// once coloumn is identified then scan entire test cases coloumn to identify
	// purchase test case row
	// after you grab purchase testcase row = pull all the data of that row and feed
	// into test

	public ArrayList<String> getData(String testcaseName) throws IOException {

		ArrayList<String> a = new ArrayList<String>(); // creating array;ist to store the data grabbed from teh excel
		// fileInputStream argument-->wrapping excel file as a input stream object
		FileInputStream fis = new FileInputStream("E://Selenium Practises//demodata.xlsx"); // opening channel to read
																							// data
		XSSFWorkbook workbook = new XSSFWorkbook(fis); // now workbook has a ability to go inside the excel

		int sheets = workbook.getNumberOfSheets(); // get the number of sheets in the excel. Return type is int
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("Testdata")) {
				XSSFSheet sheet = workbook.getSheetAt(i); // return type is XSSFSheet

				// Identify Test cases coloumn by scanning the entire 1st row

				Iterator<Row> rows = sheet.iterator();// sheet is collection of rows. return type is Iterator<Row>
				Row firstrow = rows.next(); // one next meanse control will come to next row. Inthis line we got access
											// to first row that is TestCases
				Iterator<Cell> ce = firstrow.cellIterator();// row is collection of cells. Here we will get the next
															// cell of the first row that is Data1
				int k = 0;
				int coloumn = 0;
				while (ce.hasNext()) // reading data from the each cell in the row
				{
					Cell value = ce.next(); // grab the value from the cell
					if (value.getStringCellValue().equalsIgnoreCase("Testcases")) {
						coloumn = k;
					}
					k++;
				}
				System.out.println(coloumn);

				// once coloumn is identified then scan entire testcase coloum to identify
				// purcjhase testcase row
				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase("testcaseName")) // column will find
					{

						// after you grab testcaseName testcase row = pull all the data of that row and
						// feed into test
						Iterator<Cell> cv = r.cellIterator(); // iterate all teh cells of Purchase and grab all the values
						while (cv.hasNext()) {
							Cell c = cv.next();
							if(c.getCellType()==CellType.STRING) // using to check the cell value is string or not
							{
								a.add(c.getStringCellValue()); // adding data to the array
							} else {
								a.add(NumberToTextConverter.toText(c.getNumericCellValue())); // else get the numeric value by converting from string to number

							}
						}
					}

				}

			}
		}
		return a;

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

	}

}
