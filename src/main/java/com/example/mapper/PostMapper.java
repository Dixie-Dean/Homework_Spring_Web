package com.example.mapper;

import com.example.model.Post;
import com.example.model.PostDTO;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface PostMapper {
    Post dtoToPost(PostDTO postDTO);
    PostDTO postToDto(Post post);
}
