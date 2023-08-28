package com.example.service;

import com.example.exception.NotFoundException;
import com.example.model.Post;
import com.example.model.PostDTO;
import com.example.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<PostDTO> all() {
//        return repository.all();
    }

    public PostDTO getById(long id) {
//        return repository.getById(id).orElseThrow(NotFoundException::new);
    }

    public PostDTO save(Post post) throws NotFoundException {
//        return repository.save(post);
    }

    public void removeById(long id) {
        repository.removeById(id);
    }
}
