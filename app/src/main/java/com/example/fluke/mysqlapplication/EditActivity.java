package com.example.fluke.mysqlapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {
    EditText edit_taskname;
    Button btn_Edit;
    Button btn_Delete;
    TodoList todoEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        edit_taskname = (EditText)findViewById(R.id.edit_taskname);
        todoEdit = (TodoList) getIntent().getSerializableExtra("EditTodolist");
        edit_taskname.setText(todoEdit.getTaskname());
        btn_Edit = (Button)findViewById(R.id.btn_Edit);
        btn_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TodoList updateTodoList = new TodoList();
                updateTodoList.setTaskid(todoEdit.getTaskid());
                updateTodoList.setTaskname(String.valueOf(edit_taskname.getText()));


                TodoListDAO editTodoListDAO = new TodoListDAO(getApplicationContext());
                editTodoListDAO.open();
                editTodoListDAO.update(updateTodoList);
                editTodoListDAO.close();
                finish();
            }
        });

        btn_Delete = (Button) findViewById(R.id.btn_Delete);
        btn_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TodoListDAO deleteTodoListDAO = new TodoListDAO(getApplicationContext());
                deleteTodoListDAO.open();
                deleteTodoListDAO.delete(todoEdit);
                deleteTodoListDAO.close();
                finish();
            }
        });

    }//onCreate
}
