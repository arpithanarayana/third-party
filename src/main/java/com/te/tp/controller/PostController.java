package com.te.tp.controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.te.tp.entity.Post;
import com.te.tp.response.SuccessResponse;
import com.te.tp.service.PostService;

import ch.qos.logback.core.net.server.Client;
import lombok.RequiredArgsConstructor;
import lombok.var;

@RequiredArgsConstructor
@RestController
@RequestMapping(path= "/api")
public class PostController {
	
	private final PostService postService;
	
	@GetMapping("/getAllPost")
	public ResponseEntity<SuccessResponse> getAllPosts() throws IOException, InterruptedException {
		var url = "https://jsonplaceholder.typicode.com/posts";
		var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
		var client = HttpClient.newBuilder().build();
		var response = client.send(request, HttpResponse.BodyHandlers.ofString());
		int statusCode = response.statusCode();
		if(statusCode == 200) {
			ObjectMapper objectMapper = new ObjectMapper();
			List<Post> posts = objectMapper.readValue(response.body(), new TypeReference<List<Post>>() {});
			String message = postService.saveAllPost(posts);
		}
		return ResponseEntity.ofNullable(SuccessResponse.builder()
				.status(HttpStatus.valueOf(statusCode))
				.data(response.body())
				.timestamp(LocalDateTime.now())
				.build());
	}
}
