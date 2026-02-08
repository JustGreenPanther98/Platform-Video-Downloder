package com.video.response;

public class InstagramDownloadResponse {
	public class Content{
	    public String media_url;
	    public String thumbnail_url;
	}

	public class Data{
	    public String title;
	    public Content content;
	}

	public class Root{
	    public boolean success;
	    public String media_type;
	    public Data data;
	}
}
