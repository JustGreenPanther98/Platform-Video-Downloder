package com.video.service.Impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.video.response.YoutubeDownloadResponse;
import com.video.service.YoutubeService;

@Service
public class YoutubeServiceImpl implements YoutubeService {

	private final RestTemplate restTemplate;
	@Value("${x-rapidapi-key}")
	private String apiKey;
	@Value("${youtube-x-rapidapi-host}")
	private String apiHost;
	private String api;

	public YoutubeServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public YoutubeDownloadResponse downloadVideo(String link,boolean longVideo) {

		if(longVideo) {
			api="https://yt-api.p.rapidapi.com/dl?id=" + getIdFromLongVideoLink(link);
		}
		else {
			api="https://yt-api.p.rapidapi.com/dl?id=" + getIdFromShortsLink(link);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.set("x-rapidapi-key", apiKey);
		headers.set("x-rapidapi-host", apiHost);
		headers.set("Content-Type", "application/json");

		var httpHeader = new HttpEntity<>(headers); //HTTPEntity => It has header and Body fields

		ResponseEntity<YoutubeDownloadResponse> response = restTemplate.exchange(api, HttpMethod.GET, httpHeader,
				YoutubeDownloadResponse.class);

		if (response.getBody() == null) {
			throw new RuntimeException("The link is invalid, no value exist");
		}

		return response.getBody();

	}

	public String getIdFromLongVideoLink(String link) {

		if (link.contains("https://www.youtube.com")) {
			return link.replace("https://www.youtube.com/watch?v=", "").split("\\?")[0];

		} else if (link.contains("https://youtu.be/")) {
			return link.replace("https://youtu.be/", "").split("\\?")[0];
		} else {
			throw new RuntimeException("Please provide correct link\n[In form of (https://www.youtube.com)]");
		}
	}

	public String getIdFromShortsLink(String link) {

		if (link.contains("https://www.youtube.com/shorts/")) {
			return link.replace("https://www.youtube.com/shorts/", "").split("\\?")[0];

		} else {
			throw new RuntimeException("Please provide correct link for shorts\n[In form of (https://www.youtube.com/shorts)]");
		}
	}
}
