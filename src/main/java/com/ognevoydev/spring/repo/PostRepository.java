package com.ognevoydev.spring.repo;

import com.ognevoydev.spring.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
