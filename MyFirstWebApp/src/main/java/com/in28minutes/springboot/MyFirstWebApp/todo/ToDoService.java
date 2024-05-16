package com.in28minutes.springboot.MyFirstWebApp.todo;
import jdk.dynalink.Operation;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.annotation.Repeatable;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

@Service
public class ToDoService {
      /*private static LinkedHashMap<Integer,Todo> todos=new LinkedHashMap<>();
      private static Queue<Integer> prevDeleted=new LinkedList<>();
      private static Stack<Undo>undo=new Stack<>();
      private static Stack<Undo>redo=new Stack<>();
        static int count = 0;
        static {
        todos.put(++count, new Todo(count, "saikiran", "LearnSpringBoot", LocalDate.now().plusDays(3), false));
        todos.put(++count, new Todo(count, "saikiran", "LearnHibernate", LocalDate.now().plusDays(30), false));
        todos.put(++count, new Todo(count, "saikiran", "LearnAWS", LocalDate.now().plusDays(50), false));
        //Collections.sort(todos,new SortById());
    }
        public List<Todo> findByUsername (String username){
        Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.values().stream().filter(predicate).toList();
    }
        public void addToDo (String name, String description, LocalDate deadline,boolean flag)
        {
            //updateCount();
            if(prevDeleted.isEmpty()) {
                todos.put(++count, new Todo(count, name, description, deadline, flag));
                undo.add(new Undo("add", new Todo(count, name, description, deadline, flag)));
                return;
            }
            todos.put(prevDeleted.peek(),new Todo(prevDeleted.peek(),name,description,deadline,flag));
            undo.add(new Undo("add", new Todo(prevDeleted.peek(),name,description,deadline,flag)));
            prevDeleted.poll();

            return;
        }
        public void deleteById ( int id)
        {
            undo.add(new Undo("delete",todos.get(id)));
            prevDeleted.offer(id);
            todos.remove(id);
            return;
        }
        public Todo findById ( int id)
        {
            return todos.get(id);
        }
        public void updateToDo (Todo todo){
        /*
        Todo todos = findById(todo.getId());
        undo.add(new Undo("update",todos));
        todos.setDescription(todo.getDescription());
            undo.add(new Undo("update",todos.get(todo.getId())));
            todos.replace(todo.getId(),todo);
        }
        public void undo()
        {
               if(undo.isEmpty()==true) return;
               Undo operation = undo.pop();
               redo.add(operation);
               //redo.add(new Undo(operation.getAction(),todos.get(operation.getValue().getId())));
               Todo value= operation.getValue();
               switch(operation.getAction()) {

                   case "add": {
                       deleteById(value.getId());
                       break;
                   }
                   case "delete":
                               {
                                   todos.put(value.getId(),value);
                                   prevDeleted.poll();
                                   break;
                               }
                   case "update":
                               {
                                   redo.pop();
                                   todos.get(value.getId()).setDescription(value.getDescription());
                                   redo.add(new Undo(operation.getAction(),todos.get(value.getId())));
                                   break;
                               }


               }
        }
    public void redo()
    {
        if(redo.isEmpty()==true) return;
        Undo operation = redo.pop();
        undo.add(operation);
        Todo value= operation.getValue();
        switch(operation.getAction()) {

            case "delete": {
                deleteById(value.getId());
                break;
            }
            case "add":
            {
                prevDeleted.poll();
                todos.put(value.getId(),value);
                break;
            }
            case "update":
            {

                todos.get(value.getId()).setDescription(value.getDescription());
                break;
            }


        }
    }*/
    private static final List<Todo> todos=new ArrayList<>();
    static int count=0;
    static  {
        todos.add(new Todo(++count,"saikiran","LearnSpringBoot", LocalDate.now().plusDays(3),false));
        todos.add(new Todo(++count,"saikiran","LearnHibernate", LocalDate.now().plusDays(30),false));
        todos.add(new Todo(++count,"saikiran","LearnAWS", LocalDate.now().plusDays(50),false));
        //Collections.sort(todos,new SortById());
    }

    public List<Todo>findByUsername(String username)  {
        Predicate<? super Todo> predicate=todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }
    public void addToDo(String name,String description,LocalDate deadline,boolean flag)
    {
        //updateCount();
        todos.add(new Todo(++count,name,description,deadline,flag));
       // Collections.sort(todos,new SortById());
        return;
    }
    public void deleteById(int id)
    {

        Predicate<? super Todo> predicate=todo -> todo.getId()==id;
        todos.removeIf(predicate);
        //Collections.sort(todos,new SortById());
    }
    public Todo findById(int id)
    {
        Predicate<? super Todo> predicate=todo -> todo.getId()==id;
        Todo todo= todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateToDo(Todo todo) {
        //deleteById(todo.getId());
        Todo todos=findById(todo.getId());
        todos.setDescription(todo.getDescription());
       // todos.add(todo);
        //Collections.sort(todos,new SortById());
    }



}
