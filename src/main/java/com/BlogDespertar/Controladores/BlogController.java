package com.BlogDespertar.Controladores;

import com.BlogDespertar.Entidades.Post;
import com.BlogDespertar.Servicio.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1")
public class BlogController {

    private final PostService postService;

    public BlogController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = "/index")
    public String BlogIndex() {
        return "Version 1.0";
    }
    @GetMapping(value = "/allPost")
    public List<Post> allPost(){
        return postService.getAllPost();
    }
    @PostMapping(value = "/addPost",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addPost(@RequestBody Post post){
        Post mewPost = postService.addPost(post);

        return new ResponseEntity<>(mewPost, HttpStatus.CREATED);

    }

}
