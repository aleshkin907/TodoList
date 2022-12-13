package com.web.todo.controllers;

import com.web.todo.models.TodoList;
import com.web.todo.repo.TodoListRepository;
import com.web.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class MainController {
    private ToDoService service;

    public MainController(ToDoService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String getLists( Model model) {
        Iterable<TodoList> todoLists = this.service.findAll();
        model.addAttribute("todoLists", todoLists);
        return "todolists";
    }

    @PostMapping("/")
    public String postLists(@RequestParam String title, @RequestParam String description, Model model){
        TodoList todoList = new TodoList(title, description);
        this.service.saveList(todoList);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String editList(@PathVariable(value = "id") Long id, Model model){
        Optional<TodoList> todoList = this.service.findById(id);
        model.addAttribute("todoLists", todoList);
        return "todolists-edit";
    }

    @PostMapping("/{id}/edit")
    public String updateList(@PathVariable(value = "id") Long id, @RequestParam String title, @RequestParam String description, Model model){
        TodoList todoList = this.service.findById(id).orElseThrow();
        todoList.setTitle(title);
        todoList.setDescription(description);
        this.service.saveList(todoList);
        return "redirect:/";
    }

    @PostMapping("/{id}/delete")
    public String deleteList(@PathVariable(value = "id") Long id, Model model){
        TodoList todoList = this.service.findById(id).orElseThrow();
        this.service.deleteList(todoList);
        return "redirect:/";
    }

//    @Autowired
//    private TodoListRepository todoListRepository;
//
//    @GetMapping("/hello")
//    public String hello(Model model){
//        Iterable<TodoList> todoLists = todoListRepository.findAll();
//        model.addAttribute("todoLists", todoLists);
//        return "hello";
//    }
//bcrypt
}
