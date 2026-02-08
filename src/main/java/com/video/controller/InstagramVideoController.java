package com.video.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.video.response.InstagramDownloadResponse;
import com.video.service.Impl.InstagramServiceImpl;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/v1/instagram")
@Tag(name = "Instagram APIs", description = "Instagram reels can be downloaded")
public class InstagramVideoController {

	private InstagramServiceImpl instagramServiceImpl;

	public InstagramVideoController(InstagramServiceImpl instagramServiceImpl) {
		this.instagramServiceImpl = instagramServiceImpl;
	}

	@GetMapping(path = "/reels/download")
	public InstagramDownloadResponse downloadReels(@RequestParam("url") String link) {
		return instagramServiceImpl.downloadVideo(link);
	}
}
