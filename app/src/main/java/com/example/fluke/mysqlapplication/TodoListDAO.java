package com.example.fluke.mysqlapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Fluke on 10/2/2560.
 */

public class TodoListDAO {
    private SQLiteDatabase database;
    private DbHelper dbHelper;

    public TodoListDAO(Context context){
        dbHelper = new DbHelper(context);
    }//TodoListDAO

    public void open(){
        database = dbHelper.getWritableDatabase();
    }//open

    public void close(){
        dbHelper.close();
    }//close

    public ArrayList<TodoList> getAlltodoList(){
        ArrayList<TodoList> todoList =  new ArrayList<TodoList>();
        Cursor cursor = database.rawQuery("SELECT * FROM tbtodo_list;",null);
        cursor.moveToFirst();
        TodoList todoList1;
        while (!cursor.isAfterLast()){
            todoList1 = new TodoList();
            todoList1.setTaskid(cursor.getInt(0)); //getInt(0) คือ id อยู่คอลัมป์ที่ 0 และมีค่าเป็น int
            todoList1.setTaskname(cursor.getString(1));
            todoList.add(todoList1);//กำหนดค่าเข้าไป
            cursor.moveToNext();
        }//while
        cursor.close();
        return todoList;
    }//ArrayList

    public void add(TodoList t){
        ContentValues value = new ContentValues();
        value.put("taskname",t.getTaskname());
        this.database.insert("tbtodo_list",null,value);
        Log.d("Todo List Demo : : :","Add OK");
    }//add

    public void update(TodoList u){
        ContentValues value = new ContentValues();
        value.put("taskname",u.getTaskname());
        String where = "taskid="+u.getTaskid();

        Log.d("Taskid-->", String.valueOf(u.getTaskid()));
        Log.d("Taskname-->",u.getTaskname());
        this.database.update("tbtodo_list", value, where,null);
        Log.d("Todo List Demo : : :","Update OK");
    }//update

    public void delete(TodoList d){
        String sql = "DELETE FROM tbtodo_list WHERE taskid = " +d.getTaskid();
        this.database.execSQL(sql);
    }//delete

}//class
