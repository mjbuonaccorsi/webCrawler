package com.buono.crawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.buono.crawler.impl.InternetJSONImpl;
import com.buono.crawler.impl.WebCrawlerImpl;

@SpringBootApplication
public class WebCrawlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebCrawlerApplication.class, args);
	}
	
	@Bean
    public Internet inet() {
        return new InternetJSONImpl();
    }

	@Bean
    public WebCrawler webCrawler() {
        return new WebCrawlerImpl();
    }
	
	
	 
	 
}
