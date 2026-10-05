package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	// Data Provider 1
	@DataProvider(name = "Logindata")
	public String[][] getdata() throws IOException {
		String path = ".\\testData\\Opencart_LoginData.xlsx"; // Taking xl file from here

		ExcelUtility util = new ExcelUtility(path); // Creating object of ExcelUtility Class
		int totalrows = util.getRowCount("Sheet1");
		int totalcells = util.getCellCount("Sheet1", 1);

		String Logindata[][] = new String[totalrows][totalcells];
		for (int i = 1; i <= totalrows; i++) {
			for (int r = 0; i <= totalcells; r++) {
				Logindata[i-1][r]= util.getCellData("Sheet1", i, r);
			}
			
		}

		return Logindata;
	}

}
