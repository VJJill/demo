package com.example.demo;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CategoryData {
	private ArrayList<Result> results;
	private String category;
	
	public ArrayList<Result> getResults() {
		return this.results;
	}
	
    public String getCategory() {
    	return this.results.get(0).getCategory();
    }
}