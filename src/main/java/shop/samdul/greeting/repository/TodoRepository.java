package shop.samdul.greeting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.samdul.greeting.entitiy.TodoEntity;

public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {

}
