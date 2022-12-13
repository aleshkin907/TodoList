package com.web.todo.service;

import com.web.todo.models.TodoList;
import com.web.todo.repo.TodoListRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ToDoService {

    private TodoListRepository repository;

    public ToDoService(TodoListRepository repository) {

        this.repository = repository;
    }

    public Iterable<TodoList> findAll() {
        return this.repository.findAll();
    }

    public void saveList(TodoList todoList){
        this.repository.save(todoList);
    }

    public Optional<TodoList> findById(long id){
        return this.repository.findById(id);
    }

    public void deleteList(TodoList todoList){
        this.repository.delete(todoList);
    }
}

