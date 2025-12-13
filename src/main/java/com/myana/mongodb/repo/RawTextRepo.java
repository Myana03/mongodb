package com.myana.mongodb.repo;

import com.myana.mongodb.models.RawText;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RawTextRepo extends MongoRepository<RawText, String> {
}
