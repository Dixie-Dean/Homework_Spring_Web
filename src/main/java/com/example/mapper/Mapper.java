package com.example.mapper;

import com.example.model.Post;
import com.example.model.PostDTO;

@org.mapstruct.Mapper
public interface Mapper {
    PostDTO postToDto (Post post);
    Post dtoToPost (PostDTO postDTO);

}
