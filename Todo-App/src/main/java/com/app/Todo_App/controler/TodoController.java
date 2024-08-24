package com.app.Todo_App.controler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.Todo_App.entity.Todo;
import com.app.Todo_App.service.TodoService;

import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("todos", todoService.getAllTodos());
        return "index";
    }

    @PostMapping("/add")
    public String add(@RequestParam String activity) {
        Todo todo = new Todo();
        todo.setActivity(activity);
        todo.setCompleted(false);
        todoService.addTodo(todo);
        return "redirect:/";
    }

    @PostMapping("/toggle/{id}")
    public String toggle(@PathVariable Long id) {
        todoService.toggleTodoCompletion(id);
        return "redirect:/";
    }
}
