package com.in28minutes.springboot.MyFirstWebApp.todo;

import java.util.Comparator;

public class SortById implements Comparator<Todo>{

    @Override
    public int compare(Todo o1, Todo o2) {
        return o1.getId()-o2.getId();
    }
}
