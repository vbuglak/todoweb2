/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.todoweb.dao;

import com.todoweb.models.PgTasks;
import java.util.Collection;
import java.sql.SQLException;

public interface TaskDAO {
  public void addTask(PgTasks task) throws SQLException;
  public void updateTask(Integer Task_id, PgTasks bus) throws SQLException;
  public PgTasks getTaskById(Integer Task_id) throws SQLException;
  public Collection getAllTasks() throws SQLException;
  public void deleteTask(PgTasks task) throws SQLException;
  

}
