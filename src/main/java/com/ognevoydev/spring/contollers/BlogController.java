package com.ognevoydev.spring.contollers;

import com.ognevoydev.spring.exceptions.ResourceNotFoundException;
import com.ognevoydev.spring.models.Post;
import com.ognevoydev.spring.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private PostService postService;

    @ModelAttribute(value = "post")
    public Post newPost()
    {
        return new Post();
    }

    @GetMapping("")
    public Iterable<Post> blogMain(Model model) {
        Iterable<Post> posts = postService.getAllPosts();
        return posts;
    }

    @GetMapping("/add")
    public String blogAdd(Model model) {
        return "Blog adding page";
    }

    @PostMapping("/add")
    public Post blogPostAdd(@RequestBody Post post, Model model) {
        return postService.savePost(post);
    }

    @GetMapping("/{id}")
    public Post blogDetails(@PathVariable(value = "id") Long postId, Model model) {
        return postService.getPostById(postId);
    }

    @GetMapping("/{id}/edit")
    public Post blogEdit(@PathVariable(value = "id") Long postId, Model model) {
        Post result = postService.getPostById(postId);
        return result;
    }

    @PostMapping("/{id}/edit")
    public Post blogPostUpdate(@PathVariable(value = "id") Long postId,
                               @RequestBody Post postUPD, Model model) {
        Post result = postService.updatePostById(postId, postUPD);
        return result;
    }

    @PostMapping("/{id}/remove")
    public String blogPostDelete(@PathVariable(value = "id") Long postId,
                                 Model model) {
        postService.deletePostById(postId);
        return "Post with id " + postId + " deleted successfully";
    }

}