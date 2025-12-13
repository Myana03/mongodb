package com.myana.mongodb.repo;

import com.myana.mongodb.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends MongoRepository<Post,String> {

}
