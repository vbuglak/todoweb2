/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.todoweb.service;

/**
 *
 * @author crazycrosshair
 */
import com.todoweb.dao.daoimp.TaskDAOImp;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TaskService {
    @Autowired
    private TaskDAOImp taskdaoimp;
    
public List getAllTasks() throws SQLException{
    return taskdaoimp.getAllTasks();
}            
}
