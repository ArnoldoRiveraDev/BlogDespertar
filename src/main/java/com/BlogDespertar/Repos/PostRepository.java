package com.BlogDespertar.Repos;

import com.BlogDespertar.Entidades.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
