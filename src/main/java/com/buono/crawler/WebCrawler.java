package com.buono.crawler;

import org.springframework.stereotype.Component;

@Component
public interface WebCrawler {

	public void crawl();
	public void reset();
	public CrawlResult getResult();
	public void printResults();

}
