package com.video.service.Impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.video.configurations.SwaggerConfiguration;
import com.video.response.InstagramDownloadResponse;
import com.video.service.InstagramService;

@Service
public class InstagramServiceImpl implements InstagramService {

    private final SwaggerConfiguration swaggerConfiguration;

	@Value("${x-rapidapi-key}")
	private String apiKey;
	@Value("${instagram-x-rapidapi-host}")
	private String apiHost;
	private final RestTemplate restTemplate;
	private String api;

	public InstagramServiceImpl(RestTemplate restTemplate, SwaggerConfiguration swaggerConfiguration) {
		this.restTemplate = restTemplate;
		this.swaggerConfiguration = swaggerConfiguration;
	}

	@Override
	public InstagramDownloadResponse downloadVideo(String link) {
		
		if(link.isEmpty()|| !link.contains("https://www.instagram.com/")) {
			throw new RuntimeException("Invalid link");
		}
		
		api = "https://instagram-story-downloader-media-downloader.p.rapidapi.com/unified/url?url=" + link;
		
		HttpHeaders header = new HttpHeaders();
		header.set("x-rapidapi-key", apiKey);
		header.set("x-rapidapi-host", apiHost);
		
		var http = new HttpEntity(header);
		
		var response = restTemplate.exchange(api,HttpMethod.GET, http, InstagramDownloadResponse.class);
		return response.getBody();
	}

}
