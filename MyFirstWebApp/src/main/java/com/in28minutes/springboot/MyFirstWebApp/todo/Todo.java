package com.in28minutes.springboot.MyFirstWebApp.todo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import jakarta.websocket.OnMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Validated
@Entity
@SequenceGenerator(name="seq", initialValue=1007, allocationSize=100)
public  class Todo {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq")
    private int id;
    private String username;
    @Size(min=10,message = "Enter at least 10 characters")
    private String description;
    private LocalDate deadline;
    private boolean done;


}
