package com.example.service;

import com.example.exception.NotFoundException;
import com.example.mapper.PostMapper;
import com.example.model.Post;
import com.example.model.PostDTO;
import com.example.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository repository;
    private final PostMapper postMapper;

    public PostService(PostRepository repository, PostMapper postMapper) {
        this.repository = repository;
        this.postMapper = postMapper;
    }

    public List<PostDTO> all() {
        List<PostDTO> postDTOList = new ArrayList<>();
        for (Post post : repository.all()) {
            if (post.isRemoved()) {
                continue;
            }
            postDTOList.add(postMapper.postToDto(post));
        }
        return postDTOList;
    }

    public PostDTO getById(long id) {
        Post post = repository.getById(id).orElseThrow(NotFoundException::new);
        if (post.isRemoved()) {
            throw new NotFoundException();
        } else {
            return postMapper.postToDto(repository.getById(id).orElseThrow(NotFoundException::new));
        }
    }

    public PostDTO save(Post post) throws NotFoundException {
        repository.save(post);
        return postMapper.postToDto(post);
    }

    public void removeById(long id) {
        Post post = repository.getById(id).orElseThrow(NotFoundException::new);
        if (post.isRemoved()) {
            throw new NotFoundException();
        } else {
            post.remove();
        }
    }
}
