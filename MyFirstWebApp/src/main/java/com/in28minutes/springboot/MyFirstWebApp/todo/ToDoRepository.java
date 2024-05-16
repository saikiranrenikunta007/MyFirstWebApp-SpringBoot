package com.in28minutes.springboot.MyFirstWebApp.todo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoRepository extends JpaRepository<Todo,Integer> {
    List<Todo>findByUsername(String username);
    List<Todo>findByDescription(String Description);
}
