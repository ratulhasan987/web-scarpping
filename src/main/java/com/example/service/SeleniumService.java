package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.example.model.SeleniumModel;
// import com.example.repository.SeleniumRepo;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;

@Service
// @AllArgsConstructor
public class SeleniumService {
	
	@Autowired
	// SeleniumRepo seleniumRepo;
	
	//private static final will be considered as constant and the constant can be accessed within this class only.
	private static final String URL = "https://relatedwords.org/relatedto/";
	
	private final ChromeDriver driver = new ChromeDriver(); //The final modifier for finalizing the implementations of classes, methods, and variables
	
	@PostConstruct
	void postConstruct()
	{
		scrape("player");
	}
	

	
	public void scrape(final String value)
	{
		driver.get(URL+value);
			
	    List<String> list = new ArrayList<>();		
		final WebElement wordElement = driver.findElement(By.className("words"));
		final List<WebElement> wordList = wordElement.findElements(By.tagName("a"));
		// wordList.forEach(word-> list.add(word.getText()));
		wordList.forEach(word-> System.out.println(word.getText()));
		
		
		// for(String str:list) {
		// 	System.out.println("===>"+list);
		// 	SeleniumModel seleniumModel = new SeleniumModel();
		// 	seleniumModel.setRelatadAlldata(str);
		// 	seleniumRepo.save(seleniumModel);
		// }
		
				
		
//		try {
//			PrintStream myconsolePrintStream = new PrintStream(new File("N://webdata.text"));
//			System.setOut(myconsolePrintStream);
//			myconsolePrintStream.print("Ratul");
//			
//		} catch (FileNotFoundException fx) {
//			System.out.println(fx);
//		}
//		
		
		driver.quit();
	}
		

		
	}
	
