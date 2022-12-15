package com.BlogDespertar.Repos;

import com.BlogDespertar.Entidades.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, Integer> {
    Void deletePostById(UUID id);


    void  findPostById(UUID id);
}
