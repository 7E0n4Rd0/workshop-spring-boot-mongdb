package com.leon.workshopmong.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leon.workshopmong.domain.Post;
import com.leon.workshopmong.repository.PostRepository;
import com.leon.workshopmong.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		Optional<Post> post = repository.findById(id);
		return post.orElseThrow(() ->new ObjectNotFoundException("Object Not Found"));
	}
	
	public List<Post> findByTitle(String text){
		return repository.findByTitle(text);
		//return repository.findByTitleContainingIgnoreCase(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime());
		return repository.fullSearch(text, minDate, maxDate);
	}
}
