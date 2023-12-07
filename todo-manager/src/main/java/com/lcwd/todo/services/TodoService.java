package com.lcwd.todo.services;
import com.lcwd.todo.model.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;



@Component
public class TodoService {

    Logger logger = LoggerFactory.getLogger(TodoService.class);

    List<Todo> todos = new ArrayList<>();

    public Todo createTodo(Todo todo)
    {
        //create
        todos.add(todo);
        logger.info("Todos {} ", this.todos);
        return todo;
    }

    public List<Todo> getAllTodo()
    {
        return todos;
    }

    public Todo getTodo(int todoId)
    {
        Todo todo = todos.stream().filter(t -> todoId== t.getId()).findAny().get();
        logger.info("Todo : {}",todo);
        return todo;
    }
}
