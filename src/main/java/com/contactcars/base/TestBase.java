package com.contactcars.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public static XSSFWorkbook workbook;
    public static Sheet sheet;

    // Loading properties and credentials files
    public TestBase() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\sara.maghraby\\IdeaProjects\\seleniumFramework\\src\\main\\java\\com\\contactcars\\config\\config.properties");
       // FileInputStream fis = new FileInputStream("E:\\Automation\\IdeaProjects\\seleniumFramework\\src\\main\\java\\com\\contactcars\\config\\config.properties");
        prop.load(fis);

        File credentials = new File("D:\\Credentials.xlsx");
        FileInputStream fisc = new FileInputStream(credentials);
        workbook = new XSSFWorkbook(fisc);
        sheet = workbook.getSheetAt(0);
    }

    // Open chrome window
    public static void initializationOnChrome(String URL){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    // Close chrome window
    public void QuitChrome(){
        driver.quit();
    }


}
