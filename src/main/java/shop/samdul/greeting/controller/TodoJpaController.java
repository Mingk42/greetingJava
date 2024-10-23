package shop.samdul.greeting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.samdul.greeting.entitiy.TodoEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jpatodos")
public class TodoJpaController {

    private final TodoJpaService todoJpaService;

    @Autowired
    public TodoJpaController(TodoJpaService todoJpaService){
        this.todoJpaService=todoJpaService;
    }

    @GetMapping("")
    public List<TodoEntity> list(){
        System.out.println("[CONTROLLER]");

        return todoJpaService.getAllTodos();
    }

    @GetMapping("/{id}")
    public TodoEntity findById(@PathVariable int id){
        TodoEntity entity= todoJpaService.getTodoById(id);

        return entity;
    }

    @PostMapping("")
    public TodoEntity createEntity(@RequestBody TodoEntity todoEntity){
        System.out.println("[Controller] "+todoEntity.toString());

        System.out.println("insert success");

//        Map resultMap = new HashMap();
//        resultMap.put("method", "POST");
//        resultMap.put("rows", result);

        return todoJpaService.createTodo(todoEntity);
    }

    @PutMapping("/todos/{id}")
    public void updateById(@PathVariable int id, @RequestBody TodoEntity todoEntity){
        System.out.println("[Controller] "+todoEntity);
        todoJpaService.updateTodo(id, todoEntity);
        System.out.println("update success");

//        Map resultMap = new HashMap();
//        resultMap.put("method", "PUT");
//        resultMap.put("rows", result);

//        return resultMap;
    }

    @DeleteMapping("/todos/{id}")
    public void deleteById(@PathVariable int id){
        todoJpaService.deleteTodo(id);
        System.out.println(result + " rows delete success");

//        Map resultMap = new HashMap();
//        resultMap.put("method", "DELETE");
//        resultMap.put("rows", result);

//        return resultMap;
    }
}
