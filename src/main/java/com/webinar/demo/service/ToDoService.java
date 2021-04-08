package com.webinar.demo.service;

import com.webinar.demo.models.ToDo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Service
public class ToDoService {

    static ArrayList<ToDo> todos = new ArrayList<>();

    static {
        todos.add(new ToDo("1", "1 st todo", new Date(), false));
        todos.add(new ToDo("2", "2 st todo", new Date(), false));
    }

    public ArrayList<ToDo> getAllToDos() {
        return todos;
    }

    public ToDo getToDoById(String id) {
        return todos.stream().filter(todo -> id.equals(todo.getId())).findFirst().orElse(null);
    }

    public String addToDo(ToDo todo) {
        todos.add(todo);
        return todo.getId();
    }

    public String updateToDo(ToDo updatedToDo) {
        Optional<ToDo> targetTodo = todos.stream().filter(todo -> updatedToDo.getId().equals(todo.getId())).findFirst();
        if(targetTodo.isPresent()) {
            todos.remove(targetTodo.get());
            todos.add(updatedToDo);
        }
        return targetTodo.isPresent() ? "ToDo updated!!" : "ToDo doesn't Exist";
    }

    public String deleteToDo(String id) {
        Optional<ToDo> targetTodo = todos.stream().filter(todo -> todo.getId().equals(id)).findFirst();
        targetTodo.ifPresent(todo -> todos.remove(todo));
        return targetTodo.isPresent() ? "ToDo deleted!!" : "ToDo doesn't Exist";
    }

}
