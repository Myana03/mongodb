package com.myana.mongodb.Controller;

import com.myana.mongodb.models.RawText;
import com.myana.mongodb.repo.PostRepo;
import com.myana.mongodb.models.Post;
import com.myana.mongodb.repo.RawTextRepo;
import com.myana.mongodb.repo.SearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class restController {

   @Autowired
    private PostRepo postRepo;
   @Autowired
   private SearchRepo searchRepo;
   @Autowired
   private RawTextRepo rawTextRepo;
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

    @PostMapping("/upload-file")
    public RawText uploadText(@RequestParam(name = "file") MultipartFile file) throws IOException {
        String s=new String(file.getBytes(), StandardCharsets.UTF_8);
        RawText r=new RawText(file.getOriginalFilename(),s, LocalDateTime.now());
        return rawTextRepo.save(r);
    }
}
