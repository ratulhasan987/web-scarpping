package com.example.configuration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import jakarta.annotation.PostConstruct;

@Configuration
public class SeleniumConfiguration {
	
//	@Autowired
//	SeleniumService seleniumService;
	
	@PostConstruct //The PostConstruct annotation is used on a method thatneeds to be executed after dependency injection is done to performany initialization. পোস্টকনস্ট্রাক্ট @ এমন একটি পদ্ধতিতে ব্যবহৃত হয় যা কোনও প্রাথমিককরণের জন্য Dependency ইনজেকশন সম্পন্ন করার পরে কার্যকর করা দরকার।
	void postConstruct() {
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");

	}
	
	@Bean //Indicates that a method produces a bean to be managed by the Spring container. 
    public ChromeDriver driver() {
		
		final ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");//for remove chrome is being controlled by automated test software window show again
		return new ChromeDriver(chromeOptions);
	}

}
