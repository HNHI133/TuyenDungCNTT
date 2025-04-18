package features;

import actions.loginAction;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.loginPageUI;
import utils.ExcelUtils;

import java.util.List;
import java.util.Map;

public class loginTest {
    WebDriver driver;
    loginAction login;
    loginPageUI loginUI;
    String excelFilePath="data/loginData.xlsx";

    @BeforeMethod
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        login = new loginAction(driver);

    }
    @Test
    public void loginSuccessTest() throws Exception {
        driver.get("http://localhost:62536/");
        List<Map<String, String>> excelData = ExcelUtils.readExcelData(excelFilePath, "Sheet1");
        for(int i=0; i<1; i++){
            Map<String, String> rowData = excelData.get(i);
            login.clickButtonUserLogin();
            login.inputDataUserLogin(rowData.get("email"), rowData.get("password"));
            login.clickUserLogin();
        }

    }


    @AfterMethod
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }
}
