/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.todoweb.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author VBuglak
 */
@Entity
@Table(name = "pg_tasks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PgTasks.findAll", query = "SELECT p FROM PgTasks p")
    , @NamedQuery(name = "PgTasks.findByTaskId", query = "SELECT p FROM PgTasks p WHERE p.taskId = :taskId")
    , @NamedQuery(name = "PgTasks.findByName", query = "SELECT p FROM PgTasks p WHERE p.name = :name")})
public class PgTasks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "task_id")
    private Integer taskId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;

    public PgTasks() {
    }

    public PgTasks(Integer taskId) {
        this.taskId = taskId;
    }

    public PgTasks(Integer taskId, String name) {
        this.taskId = taskId;
        this.name = name;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taskId != null ? taskId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgTasks)) {
            return false;
        }
        PgTasks other = (PgTasks) object;
        if ((this.taskId == null && other.taskId != null) || (this.taskId != null && !this.taskId.equals(other.taskId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.todoweb.models.PgTasks[ taskId=" + taskId + " ]";
    }
    
}
