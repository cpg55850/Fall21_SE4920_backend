package com.example.todobackend2.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) {
        return todoService.getAllTodos(username);
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable long id) {
        return todoService.getTodo(id);
    }

    @PostMapping("/users/{username}/todos")
    public void addTodo(@PathVariable String username, @RequestBody Todo todo) {
        todoService.addTodo(todo);
    }

    @PutMapping("/users/{username}/todos/{id}")
    public void updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo) {
        todoService.updateTodo(id, todo);
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public void deleteTodo(@PathVariable String username, @PathVariable long id) {
        todoService.deleteTodo(id);
    }
}
