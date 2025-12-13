package com.myana.mongodb.repo;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.myana.mongodb.models.Post;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



@Component
public class searchRepoImpl implements SearchRepo{
    @Autowired
    MongoClient mongoClient;
    @Autowired
    MongoConverter converter;
    @Override
    public List<Post> findByText(String text) {
        List<Post> posts=new ArrayList<>();
        MongoDatabase database = mongoClient.getDatabase("telusko");
        MongoCollection<Document> collection = database.getCollection("jobpost");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                                new Document("query", text)
                                        .append("path", Arrays.asList("techs", "desc")))),
                new Document("$sort",
                        new Document("exp", -1L)),
                new Document("$limit", 6L)));

        result.forEach(doc->posts.add(converter.read(Post.class,doc)));
        return posts;
    }
}
