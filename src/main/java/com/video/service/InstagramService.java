package com.video.service;

import com.video.response.InstagramDownloadResponse;

public interface InstagramService {
	InstagramDownloadResponse downloadVideo(String link);
}
