package com.ognevoydev.spring.service;

import com.ognevoydev.spring.exceptions.ResourceNotFoundException;
import com.ognevoydev.spring.models.Post;
import com.ognevoydev.spring.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Override
    public Iterable<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post getPostById(Long postId) {
        Optional<Post> post = Optional.ofNullable(postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("No such post")));
        ArrayList<Post> result = new ArrayList<>();
        post.ifPresent(result::add);
        return result.get(0);
    }

    @Override
    public Post updatePostById(Long postId, Post postUPD) {
        Post post = getPostById(postId);
        post.setTitle(postUPD.getTitle());
        post.setAnons(postUPD.getAnons());
        post.setFull_text(postUPD.getFull_text());
        return postRepository.save(post);
    }

    @Override
    public void deletePostById(Long postId) {
        Post post = getPostById(postId);
        postRepository.delete(post);
    }

    public PostRepository getPostRepository() {
        return postRepository;
    }

    public void setPostRepository(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

}