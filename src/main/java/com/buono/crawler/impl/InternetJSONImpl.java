package com.buono.crawler.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.buono.crawler.Internet;

@Component
public class InternetJSONImpl implements Internet {

	@Autowired
	private Environment env;

	public JSONObject jsonObject;
	private Map<String, HashSet<String>> pages;

	@Override
	public HashSet<String> getLinks(String url) {
		if (pages == null) {
			this.loadData();
		}
		return pages.get(url);	
	}

	private void loadData() {
		JSONParser parser = new JSONParser();
		String path = env.getProperty("internet.JSON");
		pages = new HashMap<String, HashSet<String>>();
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream is = classLoader.getResourceAsStream(path);

		try {
			@SuppressWarnings("resource")
			java.util.Scanner s = new java.util.Scanner(classLoader.getResourceAsStream(path)).useDelimiter("\\A");
			
		    String inter = s.hasNext() ? s.next() : "";			
			Object obj = parser.parse(inter);

			jsonObject = (JSONObject) obj;
			JSONArray pgs = (JSONArray) jsonObject.get("pages");
			Iterator<JSONObject> iterator = pgs.iterator();
			String key;
			HashSet<String> linkSet; 

			while (iterator.hasNext()) {
				JSONObject page = iterator.next();
				
				
				JSONArray lnks = (JSONArray) page.get("links");
				Iterator<String> linkIterator = lnks.iterator();
				linkSet = new HashSet<String>();
				while (linkIterator.hasNext()) {
					linkSet.add(linkIterator.next());
					
				}

				pages.put(((String)page.get("address")), linkSet);
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
