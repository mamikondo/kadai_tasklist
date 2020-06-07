package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tasklist")

public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "taskid")
    private Integer taskid;

    @Column(name = "tasktitle",length = 200, nullable =false)
    private String tasktitle;

    @Column(name = "taskcontent",length = 200, nullable =false)
    private String taskcontent;

    @Column(name = "taskcreated_at",nullable =false)
    private Timestamp taskcreated_at;

    @Column(name = "taskupdated_at",nullable =false)
    private Timestamp taskupdated_at;

    public Integer getTaskid() {
        return taskid;
    }

    public void setTaskid(Integer taskid) {
        this.taskid = taskid;
    }

    public String getTasktitle() {
        return tasktitle;
    }

    public void setTasktitle(String tasktitle) {
        this.tasktitle = tasktitle;
    }

    public String getTaskcontent() {
        return taskcontent;
    }

    public void setTaskcontent(String taskcontent) {
        this.taskcontent = taskcontent;
    }

    public Timestamp getTaskcreated_at() {
        return taskcreated_at;
    }

    public void setTaskcreated_at(Timestamp taskcreated_at) {
        this.taskcreated_at = taskcreated_at;
    }

    public Timestamp getTaskupdated_at() {
        return taskupdated_at;
    }

    public void setTaskupdated_at(Timestamp taskupdated_at) {
        this.taskupdated_at = taskupdated_at;
    }




}
