package org.readpropertyfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReadPropertyFile {
	FileInputStream fileInputStream;
	Properties prop;
	@Test
	public void readFile(){
	File file = new File("C:\\\\Users\\\\admin\\\\workspace\\\\sam\\\\FileProperties\\\\Config\\\\config.properties");
	
	try
	{
		fileInputStream = new FileInputStream(file);
	}
	catch(FileNotFoundException e) {
		e.printStackTrace();
	}
	 prop = new Properties();
	try
	{
	prop.load(fileInputStream);
	}
	catch(IOException e) {
		e.printStackTrace();
	}
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\workspace\\sam\\FileProperties\\driver1\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(prop.getProperty("URL"));
	driver.findElement(By.name("email")).sendKeys(prop.getProperty("Username"));
	driver.findElement(By.name("pass")).sendKeys(prop.getProperty("Password"));
	driver.findElement(By.name("login")).click();
	System.out.println("URL ::" + prop.getProperty("URL"));
	System.out.println("User name::" +prop.getProperty("Username"));
    System.out.println("Password::" +prop.getProperty("Password"));
}
}


