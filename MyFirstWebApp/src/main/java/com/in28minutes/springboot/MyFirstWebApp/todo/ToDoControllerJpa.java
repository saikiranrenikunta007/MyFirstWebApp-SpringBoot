package com.in28minutes.springboot.MyFirstWebApp.todo;

import jakarta.persistence.SequenceGenerator;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@Slf4j
@AllArgsConstructor
@Controller
@SessionAttributes("name")
public class ToDoControllerJpa {
    //private ToDoService toDoService;
    private ToDoRepository toDoRepository;
    @RequestMapping("todos")
    public String getToDos(ModelMap model)
    {
        List<Todo>todo = toDoRepository.findByUsername(getLoginUsername());
        model.put("todos",todo);
        return "list-todos";
    }
    @GetMapping("addToDo")
    public String Update(ModelMap model) {
        String username= (String)model.get("name");
        Todo todo = new Todo(0,username,"",LocalDate.now().plusYears(1),false);
        model.addAttribute("todo",todo);
        return "todo";
    }
    @PostMapping("addToDo")
    public String addToDo(ModelMap model,  @Valid Todo todo, BindingResult res)
    {
        if(res.hasErrors()) {

            return "todo";
        }
        String username= getLoginUsername();
        todo.setUsername(username);
        //toDoService.addToDo(username,todo.getDescription(),LocalDate.now().plusYears(1),false);
        if(!toDoRepository.findByDescription(todo.getDescription()).isEmpty())
        {
            return "redirect:addToDo";
        }
        toDoRepository.save(todo);
        return "redirect:todos";
    }
    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id)
    {
        //toDoService.deleteById(id);
        toDoRepository.deleteById(id);
        return "redirect:todos";
    }
    @GetMapping("update-todo")
    public String ShowupdateTodo(@RequestParam int id,ModelMap model)
    {
        //Todo todo=toDoService.findById(id);
        Todo todo=toDoRepository.findById(id).get();
        model.addAttribute("todo",todo);
        return "todo";
    }
    @PostMapping("update-todo")
    public String updateToDo(ModelMap model,  @Valid Todo todo, BindingResult res)
    {
        if(res.hasErrors()) {

            return "todo";
        }
        todo.setUsername(getLoginUsername());
        //toDoService.updateToDo(todo);
        toDoRepository.save(todo);
        return "redirect:todos";
    }
    public String getLoginUsername()
    {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
    /*@RequestMapping("undo")
    public String getUndoOperation()
    {
        toDoService.undo();
        return "redirect:todos";
    }
    @RequestMapping("redo")
    public String getRedoOperation()
    {
        toDoService.redo();
        return "redirect:todos";
    }*/


}
