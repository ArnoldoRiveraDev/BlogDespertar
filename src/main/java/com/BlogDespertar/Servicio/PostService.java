package com.BlogDespertar.Servicio;

import com.BlogDespertar.Entidades.Post;
import com.BlogDespertar.Repos.PostRepository;
import com.BlogDespertar.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    public Post updatePost(Post post){
        return  postRepository.save(post);
    }
    public void deletePost(UUID id){
        postRepository.deletePostById(id);
    }
    public Post findPostById(UUID id){
        try{
            postRepository.findPostById(id);
        }catch (UserNotFoundException u){
            System.err.println(u);
        }
        return (Post) postRepository;
    }
}
