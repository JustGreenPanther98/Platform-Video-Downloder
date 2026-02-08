package com.video.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class FacebookDownloadResponse {
	
	public List<UrlItem> urls;
	public String pictureUrl;
	public String service;

	public static class UrlItem {
		public String url;
		public String name; //MP4 or something else
		public String subName; // HD,SD or something else
		
	}
}
