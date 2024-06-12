package com.te.tp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.te.tp.entity.Post;
import com.te.tp.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService{
	
	private final PostRepository postRepository;

	@Override
	public String saveAllPost(List<Post> posts) {
		postRepository.saveAll(posts);
		return "post details saved sucessfully";
	}

}
