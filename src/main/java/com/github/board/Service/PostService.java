package com.github.board.Service;

import com.github.board.Repository.PostEntity;
import com.github.board.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostEntity save(PostEntity newPost) {
        return postRepository.save(newPost);
    }
}
