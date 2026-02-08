package com.video.service.Impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.video.configurations.SwaggerConfiguration;
import com.video.response.FacebookDownloadResponse;
import com.video.service.FacebookService;

@Service
public class FacebookServiceImpl implements FacebookService {

	@Value("${x-rapidapi-key}")
	private String apiKey;
	@Value("${facebook-x-rapidapi-host}")
	private String apiHost;
	private final RestTemplate restTemplate;
	private String api;

	public FacebookServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public FacebookDownloadResponse downloadVideo(String link) {

		if(link==null || link.isBlank() || !link.contains("https://www.facebook.com") ) {
			throw new RuntimeException("Link is invlaid");
		}
		if(link.charAt(link.length()-1)=='/') {
			throw new RuntimeException("Kindly remove / from end of link");
		}
		api = "https://facebook17.p.rapidapi.com/api/facebook/links";

		HttpHeaders header = new HttpHeaders();
		header.set("x-rapidapi-key", apiKey);
		header.set("x-rapidapi-host", apiHost);
		header.setContentType(MediaType.APPLICATION_JSON);
		
		Map<String,String> body = new HashMap<>();
		body.put("url", link);

		var http = new HttpEntity(body, header);

		var response = restTemplate.exchange(api, HttpMethod.POST, http, FacebookDownloadResponse[].class);
		return response.getBody()[0];
	}

}
