package com.video.service;

import com.video.response.FacebookDownloadResponse;

public interface FacebookService {
	FacebookDownloadResponse downloadVideo(String link);
}
