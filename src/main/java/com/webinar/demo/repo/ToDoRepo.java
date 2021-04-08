package com.webinar.demo.repo;

import com.webinar.demo.models.ToDo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ToDoRepo extends MongoRepository<ToDo, String> {

}
