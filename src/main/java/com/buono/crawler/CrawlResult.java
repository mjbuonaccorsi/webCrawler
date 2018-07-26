package com.buono.crawler;

import java.util.LinkedHashSet;
import java.util.Set;

public class CrawlResult {

	private Set<String> visitedPages;
	private Set<String> skippedPages;
	private Set<String> errorPages;
	
	public CrawlResult() {
    	visitedPages = new LinkedHashSet<>();
    	skippedPages = new LinkedHashSet<>();
    	errorPages = new LinkedHashSet<>();
		
	}
	
	public Set<String> getVisitedPages() {
		return visitedPages;
	}
	public void setVisitedPages(Set<String> visitedPages) {
		this.visitedPages = visitedPages;
	}
	public Set<String> getSkippedPages() {
		return skippedPages;
	}
	public void setSkippedPages(Set<String> skippedPages) {
		this.skippedPages = skippedPages;
	}
	public Set<String> getErrorPages() {
		return errorPages;
	}
	public void setErrorPages(Set<String> errorPages) {
		this.errorPages = errorPages;
	}

}
