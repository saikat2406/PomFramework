package com.engine;

import static com.general.Utils.environmentMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {

    WebDriver driver=null;

    public WebDriver getDriver() {
        if(driver==null){
            switch (environmentMap.get("Browser")){
                case "chrome":
                    System.out.println("Starting Chrome Browser...");
                    System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    System.out.println("Starting Edge Browser...");
                    System.setProperty("webdriver.edge.driver", "C:\\Softwares\\msedgedriver.exe");
                    driver = new EdgeDriver();
                    break;
            }
        }

        return driver;

    }

    public void quitTest(){

        if(driver!=null){
            driver.quit();
            driver=null;
        }

    }

}
