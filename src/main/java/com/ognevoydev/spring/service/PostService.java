package com.ognevoydev.spring.service;

import com.ognevoydev.spring.models.Post;
import com.ognevoydev.spring.repo.PostRepository;
import org.springframework.stereotype.Service;

@Service
public interface PostService {

    Iterable<Post> getAllPosts();
    Post savePost(Post post);
    Post getPostById(Long postId);
    Post updatePostById(Long postId, Post postUPD);
    void deletePostById(Long postId);

    PostRepository getPostRepository();

}