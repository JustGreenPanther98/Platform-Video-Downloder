package com.video.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.video.response.YoutubeDownloadResponse;
import com.video.service.YoutubeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/youtube")
@Tag(name="Youtube APIs",description="Youtube shorts and long video can be downloaded")
public class YoutubeVideoController {
	
	private YoutubeService youtubeService;
	
	public YoutubeVideoController(YoutubeService youtubeService) {
		this.youtubeService=youtubeService;
	}
	
	@GetMapping("/download")
	@Operation(description="It takes long Youtube video (link) as input and gives download URL")
	public YoutubeDownloadResponse downloadVideo(@RequestParam("url") String youtubeLink) {
		return youtubeService.downloadVideo(youtubeLink,true);
	}
	
	@GetMapping("/shorts/download")
	@Operation(description="It takes Youtube shorts (link) as input and gives download URL")
	public YoutubeDownloadResponse downloadShortVideo(@RequestParam("url") String youtubeLink) {
		return youtubeService.downloadVideo(youtubeLink,false);
	}
	
}
