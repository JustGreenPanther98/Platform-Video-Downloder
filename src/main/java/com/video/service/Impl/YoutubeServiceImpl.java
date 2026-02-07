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

	private RestTemplate restTemplate;
	@Value("${x-rapidapi-key}")
	private String apiKey;
	@Value("${x-rapidapi-host}")
	private String apiHost;

	public YoutubeServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public YoutubeDownloadResponse downloadVideo(String Link) {

		String api = "https://yt-api.p.rapidapi.com/dl?id=" + getIdFromLongLink(Link);

		HttpHeaders headers = new HttpHeaders();
		headers.set("x-rapidapi-key", apiKey);
		headers.set("x-rapidapi-host", apiHost);
		headers.set("Content-Type", "application/json");

		var entity = new HttpEntity<>(headers);

		ResponseEntity<YoutubeDownloadResponse> response = restTemplate.exchange(api, HttpMethod.GET, entity,
				YoutubeDownloadResponse.class);

		if (response == null) {
			throw new RuntimeException("The link is invalid, no value exist");
		}

		return response.getBody();

	}

	public String getIdFromLongLink(String link) {

		if (link.contains("https://www.youtube.com")) {
			return link.replace("https://www.youtube.com/watch?v=", "").split("\\?")[0];

		} else if (link.contains("https://youtu.be/")) {
			return link.replace("https://youtu.be/", "").split("\\?")[0];
		} else {
			throw new RuntimeException("Please provide correct link\n[In form of (https://www.youtube.com)]");
		}
	}

}
