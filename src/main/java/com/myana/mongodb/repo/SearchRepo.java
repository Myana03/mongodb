package com.myana.mongodb.repo;

import com.myana.mongodb.models.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SearchRepo {
    List<Post> findByText(String text);
}
