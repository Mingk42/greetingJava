package shop.samdul.greeting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.samdul.greeting.entitiy.TodoEntity;
import shop.samdul.greeting.repository.TodoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TodoJpaService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoJpaService(TodoRepository todoRepository){
        this.todoRepository=todoRepository;
    }

    public List<TodoEntity> getAllTodos(){
        System.out.println("[SERVICE] findAll");

        return todoRepository.findAll();
    }

    public Optional<TodoEntity> getTodoById(int id){
        System.out.println("[SERVICE] findById");

        return todoRepository.findById(id);
    }

    public TodoEntity createTodo(TodoEntity todoEntity){
        System.out.println("[SERVICE] createEntity");

        return todoRepository.save(todoEntity);
    }

    public int deleteTodo(int id){
        System.out.println("[SERVICE] deleteById");

        return todoRepository.deleteById(id);
    }

    public TodoEntity updateTodo(int id, TodoEntity todoEntity){
        System.out.println("[SERVICE] updateById");
        Optional<TodoEntity> existingTodoOpt = todoRepository.findById(id);

        if(existingTodoOpt.isPresent()){
            TodoEntity existingTodo = existingTodoOpt.get();

            existingTodo.setSubject(todoEntity.getSubject());
            existingTodo.setBody(todoEntity.getBody());
            existingTodo.setCompleted(todoEntity.getCompleted());

            return todoRepository.save(existingTodo);
        } else {
            System.out.println("[SERVICE] unknown id");

            return null;
        }
    }
}
