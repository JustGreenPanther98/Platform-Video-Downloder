package com.video.configurations;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfiguration {
	@Bean
	OpenAPI myConfiguration() {
		OpenAPI openAPI = new OpenAPI();

		Info info = new Info();
		info.setTitle("Video Downloder API");
		info.setDescription("Download videos you want from top known platform!");
		info.setSummary(
				"API uses some external API (from Rapid API)\n through which you can download long videos or shorts of platforms like Youtube, Instagram and Facebook ");
		Contact contact = new Contact();
		contact.setName("Vedant Maheshwari");
		contact.setUrl("https://github.com/JustGreenPanther98");
		contact.setEmail("zippyjese@gmail.com");
		info.setContact(contact);

		openAPI.setInfo(info);

		openAPI.setServers(
				List.of(new Server().url("https://platform-video-downloder.onrender.com").description("PUBLIC"),
						new Server().url("http://localhost:2026").description("Local System")));

		return openAPI;
	}

}
