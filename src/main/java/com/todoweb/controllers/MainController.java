/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.todoweb.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.todoweb.service.TaskService;
import com.todoweb.models.PgTasks;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author VBuglak
 */
@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    private TaskService taskservice;
    @GetMapping
   public String index(ModelMap map) {
       map.put("msg", "Hello Spring 4 Web MVC!");
       return "index";
   }
    @GetMapping("tasks")
    public @ResponseBody List<PgTasks> tasks() throws SQLException{
        return taskservice.getAllTasks();
    }
   
}
