package shop.samdul.greeting.mapper;

import org.apache.ibatis.annotations.Mapper;
import shop.samdul.greeting.entitiy.TodoEntity;

import java.util.List;


@Mapper
public interface TodoMapper {
    List<TodoEntity> findAll();
    TodoEntity findById(int id);

    //TodoEntity createEntity(TodoEntity todoEntity);
    void createEntity(String subject, String body, Boolean completed);
    void deleteById(int id);
    void updateById(int id, String subject, String body, Boolean completed);
}
