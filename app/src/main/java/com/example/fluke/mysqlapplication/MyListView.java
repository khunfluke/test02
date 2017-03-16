package com.example.fluke.mysqlapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Fluke on 23/2/2560.
 */

public class MyListView extends BaseAdapter{
    private static Activity activity;
    private static LayoutInflater inflater;
    ArrayList<TodoList> myTdoList;

    public MyListView(Activity mainActivity, ArrayList<TodoList> myTdoList) {
        this.myTdoList = myTdoList;
        this.activity = mainActivity;
        this.inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return myTdoList.size();
    }

    @Override
    public Object getItem(int position) {
        return myTdoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return myTdoList.get(position).getTaskid();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        v = inflater.inflate(R.layout.my_list_layout,null);
        TextView textView = (TextView) v.findViewById(R.id.kuy_all);
        TodoList todoList = myTdoList.get(position);
        textView.setText(todoList.getTaskname());
        return v;
    }
}//MyListView
