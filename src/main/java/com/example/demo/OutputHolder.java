package com.example.demo;

import java.util.*;
public class OutputHolder {
	private String category;
	private ArrayList<ResultFormat> results;
	
	public String getCategory() {
		return this.category;
	}
	
	public ArrayList<ResultFormat> getResults(){
		return this.results;
	}
	
	public void setCategory(String cat) {
		this.category = cat;
	}
	
	public void setResults(ArrayList<ResultFormat> rs) {
		this.results = rs;
	}
}
