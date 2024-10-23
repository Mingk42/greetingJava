package shop.samdul.greeting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.samdul.greeting.entitiy.TodoEntity;
import shop.samdul.greeting.mapper.TodoMapper;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    TodoMapper todoMapper;

    public List<TodoEntity> getTodos(){
        System.out.println("[SERVICE] findAll");
        List<TodoEntity> todos = todoMapper.findAll();
        System.out.println("[todos] ::: "+ todos.size());
        return todos;
    }

    public TodoEntity findById(int id){
        System.out.println("[SERVICE] findById");
        TodoEntity entity = todoMapper.findById(id);
        System.out.println("[todos] ::: "+ entity.toString());
        return entity;
    }

    public int createEntity(TodoEntity todoEntity){
        System.out.println("[SERVICE] createEntity");
        System.out.println("[SERVICE] "+todoEntity.toString());
        int result = todoMapper.createEntity(todoEntity.getSubject(), todoEntity.getBody(), todoEntity.getCompleted());

        return result;
    }

    public int deleteById(int id){
        System.out.println("[SERVICE] deleteById");
        int result = todoMapper.deleteById(id);

        return result;
    }

    public int updateById(TodoEntity todoEntity){
        System.out.println("[SERVICE] updateById");
        int result = todoMapper.updateById(todoEntity.getId(), todoEntity.getSubject(), todoEntity.getBody(), todoEntity.getCompleted());

        return result;
    }
}
