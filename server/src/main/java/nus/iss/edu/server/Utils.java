package nus.iss.edu.server;

import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonReader;
import nus.iss.edu.server.models.Todo;
import nus.iss.edu.server.models.User;

public class Utils {
    
    public static JsonObject toJson(String j){
        JsonReader reader = Json.createReader(new StringReader(j));
		User u = toUser(reader.readObject());
        return toJson(u).asJsonObject();   
    }

    public static User toUser(JsonObject j){

        User u = new User();
        u.setEmail(j.getString("email"));
        u.setName(j.getString("name"));
        List<Todo> todoList = new LinkedList<>();
        todoList =  j.getJsonArray("todo")
            .stream()
            .map(v -> v.asJsonObject())
            .map(v -> createTodo(v))
            .toList();
        u.setTodoList(todoList);
        return u;
        
    }

    public static JsonObjectBuilder createTodo(Todo t){
        return Json.createObjectBuilder()
                    .add("activity", t.getActivity())
                    .add("date", t.getDate());
    }

    public static Todo createTodo(JsonObject j){
        Todo t = new Todo();
        t.setActivity(j.getString("activity"));
        t.setDate(j.getString("date"));
        return t;
    }

    public static JsonObject toJson(User u){
        JsonArrayBuilder builder = Json.createArrayBuilder();
        
        List<JsonObjectBuilder> arr = u.getTodoList().stream().map(v -> createTodo(v)).toList();

        for(JsonObjectBuilder x : arr){
            builder.add(x);
        }

        return Json.createObjectBuilder()
            .add("name", u.getName())
            .add("email", u.getEmail())
            .add("todo", builder)
            .build();
    }
}
