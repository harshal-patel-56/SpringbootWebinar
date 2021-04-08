package com.webinar.demo.controllers;

import com.webinar.demo.models.ToDo;
import com.webinar.demo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ToDoController {

    @Autowired
    ToDoService toDoService;

    @GetMapping("/api/todo/")
    public ArrayList<ToDo> getAllToDos() {
        return toDoService.getAllToDos();
    }

    @GetMapping("/api/todo/{id}")
    public ToDo getToDo(@PathVariable String id) {
        return toDoService.getToDoById(id);
    }

    @PostMapping("/api/todo/")
    public String addToDo(@RequestBody ToDo todo) {
        return toDoService.addToDo(todo);
    }

    @PutMapping("/api/todo/")
    public String updateToDo(@RequestBody ToDo updatedTodo) {
        return toDoService.updateToDo(updatedTodo);
    }

    @DeleteMapping("/api/todo/{id}")
    public String deleteToDo(@PathVariable String id) {
        return toDoService.deleteToDo(id);
    }

}
