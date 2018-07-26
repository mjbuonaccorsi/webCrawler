package com.buono.crawler.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.buono.crawler.CrawlResult;
import com.buono.crawler.Internet;
import com.buono.crawler.WebCrawler;

@Component
public class WebCrawlerImpl implements WebCrawler {

	@Autowired
	Internet inet;

	@Autowired
	private Environment env;
	
	private CrawlResult crawlResult;
	
	public void reset() {
		crawlResult=new CrawlResult();	
	}

	@Override
	public void crawl() {
    	String startingPage = env.getProperty("starting.page");
    	reset();
		crawl(startingPage);
		printResults();
	}

	public void crawl(String url) {
    	
		if (inet==null) {
			System.out.println("INET is null");
		} else {
			HashSet<String> retLinks = inet.getLinks(url);
			crawlResult.getVisitedPages().add(url);
			for (String s : retLinks) {
				 retLinks = inet.getLinks(s);
				if (retLinks==null) {
					crawlResult.getErrorPages().add(s);
				} else {
					if (crawlResult.getVisitedPages().contains(s)) {
						crawlResult.getSkippedPages().add(s);
					} else {
						crawlResult.getVisitedPages().add(s);
						crawl(s);
					}
				}
			}
		}	
	}
	
	public void printResults() {
		printHashSet("Success",crawlResult.getVisitedPages());
		printHashSet("\nSkipped", crawlResult.getSkippedPages());
		printHashSet("\nError", crawlResult.getErrorPages());		
	}
	
	private void printHashSet(String heading, Set<String> set) {
		System.out.println(heading+": ");
		System.out.print("[");
		int counter = 1;
		for (String s : set) {
			System.out.print("\"" + s +"\"");
			if (counter<set.size() &&  counter % 2 >0) {
				System.out.print(",");
			} else if (counter<set.size()){
				System.out.println(",");
			}
			counter++;
		}
		System.out.println("]");

		
	}

	@Override
	public CrawlResult getResult() {
		return crawlResult;
	}

}
