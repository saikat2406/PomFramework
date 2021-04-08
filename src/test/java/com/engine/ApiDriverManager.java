package com.engine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static com.general.Utils.environmentMap;

public class ApiDriverManager {

    WebDriver driver=null;

    public WebDriver getDriver() {
        if(driver==null){
            switch (environmentMap.get("Browser")){
                case "chrome":
                    System.out.println("Starting Chrome Browser");
                    System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver.exe");
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    break;
                case "edge":
                    System.out.println("Starting Edge Browser");
                    System.setProperty("webdriver.edge.driver", "C:\\Softwares\\msedgedriver.exe");
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
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
