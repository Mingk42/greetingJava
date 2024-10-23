package shop.samdul.greeting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.samdul.greeting.entitiy.TodoEntity;
import shop.samdul.greeting.service.TodoService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map createEntity(@RequestBody TodoEntity todoEntity){
        System.out.println("[Controller] "+todoEntity.toString());
        int result = todoService.createEntity(todoEntity);
        System.out.println("insert success");

        Map resultMap = new HashMap();
        resultMap.put("method", "POST");
        resultMap.put("rows", result);

        return resultMap;
    }

    @DeleteMapping("/todos/{id}")
    public Map deleteById(@PathVariable int id){
        int result = todoService.deleteById(id);
        System.out.println(result + " rows delete success");

        Map resultMap = new HashMap();
        resultMap.put("method", "DELETE");
        resultMap.put("rows", result);

        return resultMap;
    }

    @PutMapping("/todos/{id}")
    public Map updateById(@PathVariable int id, @RequestBody TodoEntity todoEntity){
        todoEntity.setId(id);

        System.out.println("[Controller] "+todoEntity);
        int result = todoService.updateById(todoEntity);
        System.out.println("update success");

        Map resultMap = new HashMap();
        resultMap.put("method", "PUT");
        resultMap.put("rows", result);

        return resultMap;
    }
}
