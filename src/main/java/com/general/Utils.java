package com.general;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Utils {

    public static Map<String, String> assertMap = new HashMap<>();

    public static void rememberTheValue(String key, String value){
        assertMap.put(key, value);
    }

    public static String whatIsTheValue(String key){
        return assertMap.get(key);
    }

    public static void waitForElement(WebDriver driver, String xPtah){
        WebDriverWait waitDriver = new WebDriverWait(driver, 60);
        waitDriver.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xPtah))));
    }

    public static String getData(String key) throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src\\main\\resources\\env-test.properties");
        properties.load(fileInputStream);
        return properties.getProperty(key);
    }

}
