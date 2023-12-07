package com.lcwd.todo.controllers;

import com.lcwd.todo.model.Todo;
import com.lcwd.todo.services.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/todos")
public class TodoController {

    Logger logger = LoggerFactory.getLogger(TodoController.class);

    @Autowired
    private TodoService todoService;

    Random random = new Random();


    //Create API
    @PostMapping
    public ResponseEntity<Todo> createTodoHandler(@RequestBody Todo todo)
    {
        //Print data record
        logger.info("Create Todo");

        //Generate Random ID
        int id = random.nextInt(9999999);
        todo.setId(id);

        //To add data into todo
        Todo todo1 = todoService.createTodo(todo);

        return new ResponseEntity<>(todo1, HttpStatus.CREATED);
    }


    //Get All Todo method API
    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodoHandler(){
        List<Todo> allTodos = todoService.getAllTodo();
        return new ResponseEntity<>(allTodos, HttpStatus.OK);
    }

    // Get Single Todo
    @GetMapping("/{todoId}")
    public ResponseEntity<Todo> getSingleTodoHandler(@PathVariable int todoId){

       Todo todo = todoService.getTodo(todoId);
       return ResponseEntity.ok(todo);
    }


}
