package com.video.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record YoutubeDownloadResponse(String title,List<YoutubeFormat> formats) {

}
