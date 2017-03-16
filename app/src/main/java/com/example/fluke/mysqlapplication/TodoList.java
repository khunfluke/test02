package com.example.fluke.mysqlapplication;

import java.io.Serializable;

/**
 * Created by Fluke on 10/2/2560.
 */

public class TodoList implements Serializable {
    public int taskid;
    public String taskname;

    public int getTaskid() {
        return taskid;
    }//getTaskid

    public String getTaskname() {
        return taskname;
    }//getTaskname

    public void setTaskid(int taskid) {
        this.taskid = taskid;
    }//setTaskid

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }//setTaskname
}//class
