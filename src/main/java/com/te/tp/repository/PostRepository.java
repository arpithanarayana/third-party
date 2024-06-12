package com.te.tp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.tp.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
