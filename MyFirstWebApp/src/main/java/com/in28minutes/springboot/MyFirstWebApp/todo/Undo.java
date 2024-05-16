package com.in28minutes.springboot.MyFirstWebApp.todo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Undo {
    private String action;
    private Todo value;
}
