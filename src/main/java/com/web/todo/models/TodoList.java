package com.web.todo.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "list")
public class TodoList {

    public TodoList() {
    }

    public TodoList(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;

//    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
//    @JoinColumn(name = "item_id", nullable = false)
//    private TodoItem todoItem;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "todoList")
    private Set<TodoItem> todoItem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<TodoItem> getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(Set<TodoItem> todoItem) {
        this.todoItem = todoItem;
    }
}
