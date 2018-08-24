/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.todoweb.dao.daoimp;

import com.todoweb.models.PgTasks;
import java.sql.SQLException;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import com.todoweb.util.HibernateUtil;
import javax.swing.*;
import org.hibernate.Session;
import org.hibernate.Query;
import com.todoweb.dao.TaskDAO;

public class TaskDAOImp implements TaskDAO {

  public void addTask(PgTasks task) throws SQLException {
    Session session = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.save(task);
      session.getTransaction().commit();
    } catch (Exception e) {
      //JOptionPane.showMessageDialog(null, e.getMessage(), «Ошибка при вставке», JOptionPane.OK_OPTION);
    } finally {
      if (session != null && session.isOpen()) {

        session.close();
      }
    }
  }

  public void updateTask(Integer task_id, PgTasks task) throws SQLException {
    Session session = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.update(task);
      session.getTransaction().commit();
    } catch (Exception e) {
     // JOptionPane.showMessageDialog(null, e.getMessage(), «Ошибка при вставке», JOptionPane.OK_OPTION);
    } finally {
      if (session != null && session.isOpen()) {
        session.close();
      }
    }
  }

  public PgTasks getTaskById(Integer task_id) throws SQLException {
    Session session = null;
    PgTasks task = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      task = (PgTasks) session.load(PgTasks.class, task_id);
    } catch (Exception e) {
      //JOptionPane.showMessageDialog(null, e.getMessage(), «Ошибка 'findById'», JOptionPane.OK_OPTION);
    } finally {
      if (session != null && session.isOpen()) {
        session.close();
      }
    }
    return task;
  }

  public Collection getAllTasks() throws SQLException {
    Session session = null;
    List tasks = new ArrayList<PgTasks>();
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      tasks = session.createCriteria(TaskDAO.class).list();
    } catch (Exception e) {
      //JOptionPane.showMessageDialog(null, e.getMessage(), «Ошибка 'getAll'», JOptionPane.OK_OPTION);
    } finally {
      if (session != null && session.isOpen()) {
        session.close();
      }
    }
    return tasks;
  }

  public void deleteTask(PgTasks task) throws SQLException {
    Session session = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.delete(task);
      session.getTransaction().commit();
    } catch (Exception e) {
      //JOptionPane.showMessageDialog(null, e.getMessage(), «Ошибка при удалении», JOptionPane.OK_OPTION);
    } finally {
      if (session != null && session.isOpen()) {
        session.close();
      }
    }
  }
}