package com.app.Todo_App.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Todo_App.entity.Todo;
import com.app.Todo_App.repository.TodoRepository;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public void addTodo(Todo todo) {
        todoRepository.save(todo);
    }

    public void toggleTodoCompletion(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
        todo.setCompleted(!todo.isCompleted());
        todoRepository.save(todo);
    }
}

