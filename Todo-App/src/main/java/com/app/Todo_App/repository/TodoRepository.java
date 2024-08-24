package com.app.Todo_App.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Todo_App.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
