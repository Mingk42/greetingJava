package shop.samdul.greeting.entitiy;


import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TodoEntity {
    private int id;
    private String subject;
    private String body;
    private Boolean completed;
}
