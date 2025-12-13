package com.myana.mongodb.Controller;

import com.myana.mongodb.repo.PostRepo;
import com.myana.mongodb.models.Post;
import com.myana.mongodb.repo.SearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class restController {

   @Autowired
    private PostRepo postRepo;
   @Autowired
   private SearchRepo searchRepo;
    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return postRepo.findAll();
    }

    @PostMapping("/post")
    public Post addPost(@RequestBody Post post){
        return postRepo.save(post);
    }

    @GetMapping("/post/{text}")
    public List<Post> search(@PathVariable(name = "text") String searchText){
        return searchRepo.findByText(searchText);
    }
}
