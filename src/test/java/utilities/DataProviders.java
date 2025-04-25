package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    @DataProvider (name="LoginData")
    public String[][] getData() throws IOException
    {
        String path = ".\\testData\\Opencart_LoginData.xlsx"; //taking xl file from Testdata
        ExcelUtility xlutil = new ExcelUtility(path); //creating an object for Excel Utility

        int totalrows = xlutil.getRowCount("Sheet1");
        int totalcols = xlutil.getCellCount("Sheet1",1);

        String loginData[][] = new String[totalrows][totalcols];

        for(int i=1; i<=totalrows;i++)
        {
            for(int j=0; j<totalcols; j++)
            {
                loginData[i-1][j] = xlutil.getCellData("Sheet1",i,j);
            }
        }
        return loginData;
    }
}
