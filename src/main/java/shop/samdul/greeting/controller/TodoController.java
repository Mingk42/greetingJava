package shop.samdul.greeting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.samdul.greeting.entitiy.TodoEntity;
import shop.samdul.greeting.service.TodoService;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    TodoService todoService;

    @GetMapping("/todos")
    public List<TodoEntity> list(){
        System.out.println("[CONTROLLER]");
        List<TodoEntity> todos = todoService.getTodos();

        return todos;
    }

    @GetMapping("/todos/{id}")
    public TodoEntity findById(@PathVariable int id){
        TodoEntity entity= todoService.findById(id);
        return entity;
    }

    @PostMapping("/todos")
    public void createEntity(@RequestBody TodoEntity todoEntity){
        System.out.println("[Controller] "+todoEntity.toString());
        todoService.createEntity(todoEntity);
        System.out.println("insert success");
    }

    @DeleteMapping("/todos/{id}")
    public void deleteById(@PathVariable int id){
        todoService.deleteById(id);
        System.out.println(id + " delete success");
    }

    @PutMapping("/todos/{id}")
    public void updateById(@PathVariable int id, @RequestBody TodoEntity todoEntity){
        todoEntity.setId(id);

        System.out.println("[Controller] "+todoEntity.toString());
        todoService.updateById(todoEntity);
        System.out.println("update success");
    }
}
