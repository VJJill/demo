package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;

@Service
public class OutputFormatter {
		
		
		
		public String formatting(CategoryData apiA, CategoryData apiB) {
			   try {
			    	Gson gson = new GsonBuilder().create();
			    	
			    	ObjectMapper mapper = new ObjectMapper();
			    	SimpleModule module = new SimpleModule();
			    	module.addSerializer(OutputData.class,new ExternalOutputSerializer());
			    	
			    	mapper.registerModule(module);
			    	Map< String, List<String>> outMap = new HashMap<String,List<String>>();
			    	List<String> outList = new ArrayList<String>();
			    	ArrayList<CategoryData> od = new ArrayList<CategoryData>();
			    	od.add(apiA);
			    	od.add(apiB);
			    	OutputData  fd = new OutputData();
			    	fd.setFinalOutput(od);
			    	String optB = mapper.writeValueAsString(fd);
			    	
			    	return optB;
			    }
			    catch(JsonProcessingException jpe) {
			    	jpe.printStackTrace();
			    }
			   
			   return "";
		}
		
		 
}
