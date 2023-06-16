package com.footballmatch.utils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.web.client.RestTemplate;

public class ApiCaller{
	
	private final RestTemplate restTemplate;
    private final int year;
    
	public ApiCaller(RestTemplate restTemplate, int year) {
		this.restTemplate = restTemplate;
		this.year = year;
	}
	
	public FootballMatchResponse fetch() throws InterruptedException, ExecutionException{
		CompletableFuture<FootballMatchResponse> supplyAsync = CompletableFuture.supplyAsync(()->{
			FootballMatchResponse response = restTemplate.getForObject(
	                "https://jsonmock.hackerrank.com/api/football_matches?year=" + year + "&page=1",
	                FootballMatchResponse.class);
			int delay = ThreadLocalRandom.current().nextInt(3000, 6000);
	        try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return response;
		});
		return supplyAsync.get();
	}
}
