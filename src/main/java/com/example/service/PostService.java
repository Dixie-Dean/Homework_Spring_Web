package com.example.service;

import com.example.exception.NotFoundException;
import com.example.mapper.Mapper;
import com.example.model.Post;
import com.example.model.PostDTO;
import com.example.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private final PostRepository repository;
    private final Mapper mapper;

    public PostService(PostRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<PostDTO> all() {
        List<PostDTO> postDTOList = new ArrayList<>();
        for (Post post : repository.all()) {
            postDTOList.add(mapper.postToDto(post));
        }
        return postDTOList;
    }

    public PostDTO getById(long id) {
        return mapper.postToDto(repository.getById(id).orElseThrow(NotFoundException::new));
    }

    public PostDTO save(Post post) throws NotFoundException {
        repository.save(post);
        return mapper.postToDto(post);
    }

    public void removeById(long id) {
        repository.removeById(id);
    }
}
