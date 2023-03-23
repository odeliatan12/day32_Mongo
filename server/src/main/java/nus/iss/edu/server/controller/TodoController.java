package nus.iss.edu.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.json.JsonObject;
import nus.iss.edu.server.Utils;
import nus.iss.edu.server.service.TodoService;

@Controller
@CrossOrigin(origins = "*")
public class TodoController {

    @Autowired
    private TodoService service;

    @PostMapping(path = "/post")
    @ResponseBody()
    public ResponseEntity<String> insertUser(@RequestBody String payload){
        
        JsonObject jsonObject = Utils.toJson(payload);
        JsonObject obj = service.insertTodo(jsonObject);
        return ResponseEntity.status(HttpStatus.OK).body(obj.toString());
    }
    
}
