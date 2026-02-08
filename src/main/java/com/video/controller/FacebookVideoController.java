package com.video.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.video.request.FacebookDownloadRequest;
import com.video.response.FacebookDownloadResponse;
import com.video.service.FacebookService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/facebook")
@Tag(name="Facebook APIs",description="API can download facebook videos")
public class FacebookVideoController {
	
	private FacebookService facebookService;
	
	public FacebookVideoController(FacebookService facebookService) {
		this.facebookService=facebookService;
	}
	
	@PostMapping(path="/download")
	private FacebookDownloadResponse downloadVideo(@RequestBody FacebookDownloadRequest facebookDownloadRequest) {
		return facebookService.downloadVideo(facebookDownloadRequest.url());
	}
}
