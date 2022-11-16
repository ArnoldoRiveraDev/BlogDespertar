package com.BlogDespertar.Servicio;

import com.BlogDespertar.Entidades.Post;
import com.BlogDespertar.Repos.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPost(){
        return postRepository.findAll();
    }

    public Post addPost(Post post){
       return postRepository.save(post);
    }

}
