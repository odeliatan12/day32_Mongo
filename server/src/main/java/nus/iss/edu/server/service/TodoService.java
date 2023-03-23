package nus.iss.edu.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.json.JsonObject;
import nus.iss.edu.server.repo.TodoRepoImpl;

@Service
public class TodoService {

    @Autowired
    private TodoRepoImpl repository;

    public JsonObject insertTodo(JsonObject j){
        return repository.insertTodo(j);
    }
}
