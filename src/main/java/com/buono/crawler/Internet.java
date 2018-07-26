package com.buono.crawler;

import java.util.HashSet;


public interface Internet {
	
	public HashSet<String> getLinks(String url);

	
}
