package com.buono.crawler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buono.crawler.CrawlResult;
import com.buono.crawler.WebCrawler;

@RestController
public class WebCrawlerController {

	
	@Autowired
	WebCrawler webCrawler;
	
	   @RequestMapping("/")
	    public CrawlResult defaultCrawl() {
		   webCrawler.crawl();
	       return webCrawler.getResult();
	    }
	   
	   @RequestMapping("/crawl")
	    public CrawlResult userEnteredCrawl() {
		   webCrawler.reset();
		   webCrawler.crawl();
		   webCrawler.printResults();
	       return webCrawler.getResult();
	    }

}
