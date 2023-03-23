package nus.iss.edu.server.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import jakarta.json.JsonObject;

import static nus.iss.edu.server.Constants.*;

@Repository
public class TodoRepoImpl {

    @Autowired
    private MongoTemplate template;

    public JsonObject insertTodo(JsonObject j){
        return template.insert(j, COLLECTION_TODO);
    }
    
}
