package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import com.google.gson.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;

@RestController
public class DemoController {

	@Autowired
	OutputFormatter of;

	@Autowired
	DemoService dms;
	
 @GetMapping(path="/coding/exercise/quiz")
 public String dataFetcher(){
	CompletableFuture<CategoryData> apiA= 
	dms.fetchApiData("https://opentdb.com/api.php?amount=5&category=11"); // test
	CompletableFuture<CategoryData> apiB=
	dms.fetchApiData("https://opentdb.com/api.php?amount=5&category=12");
	
    CompletableFuture.allOf(apiA,apiB).join();
   
    	try {
    	String output = of.formatting(apiA.get(), apiB.get());
    	return output;
    	}
    	catch(InterruptedException ie) {
    		
    	}
    	catch(ExecutionException ee) {
    		
    	}
    	return null;
  
 }
 


}
