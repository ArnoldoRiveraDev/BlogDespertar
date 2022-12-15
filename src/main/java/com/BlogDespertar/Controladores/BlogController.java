package com.BlogDespertar.Controladores;

import com.BlogDespertar.Entidades.Post;
import com.BlogDespertar.Servicio.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
        try {
            Post mewPost = postService.addPost(post);

            return new ResponseEntity<>(mewPost, HttpStatus.CREATED);
        }catch(Exception e){

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }
    @PostMapping(value = "/update",consumes = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<Post> updAdmin(@RequestBody Post post){
        Post nuevoAdmin = postService.updatePost(post);
        return new ResponseEntity<>(nuevoAdmin,HttpStatus.OK);
    }

    @GetMapping(value = "/findOne/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Post>  findOne(@PathVariable("id") UUID id){
        Post findOne = postService.findPostById(id);
        return new ResponseEntity<>(findOne,HttpStatus.OK);
    }

    @PostMapping(value = "/delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>  deleteById(@PathVariable("id") UUID id){
        postService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
