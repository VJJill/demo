package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;

import java.util.concurrent.CompletableFuture;


@Service
public class DemoService {
	private final RestTemplate restTemplate;
	
	public DemoService(RestTemplateBuilder rtb) {
		this.restTemplate = rtb.build();
	}
	@Async
	public CompletableFuture<CategoryData> fetchApiData(String apiUrl){
		   
	CategoryData results = restTemplate.getForObject(apiUrl,CategoryData.class);
    return CompletableFuture.completedFuture(results);// test
	
	}

}
