package com.example.fluke.mysqlapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Fluke on 10/2/2560.
 */

public class DbHelper extends SQLiteOpenHelper {
    private static final String databaseName = "dbtodolist.sqlite";
    private static final int databaseVersion = 1;
    Context myContext;

    private static final String SQLCreateTable =
            "CREATE TABLE tbtodo_list("+
                    "taskid INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "taskname TEXT)";

    public DbHelper(Context context) {
        super(context, databaseName, null, databaseVersion);
        this.myContext = context;
    }//DbHelper

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLCreateTable);
        String[] insertDB;
        insertDB = new String[5];
        insertDB[0] =  "INSERT INTO tbtodo_list (taskname) VALUES ('Hello1')";
        insertDB[1] =  "INSERT INTO tbtodo_list (taskname) VALUES ('Hello2')";
        insertDB[2] =  "INSERT INTO tbtodo_list (taskname) VALUES ('Hello3')";
        insertDB[3] =  "INSERT INTO tbtodo_list (taskname) VALUES ('Hello4')";
        insertDB[4] =  "INSERT INTO tbtodo_list (taskname) VALUES ('Hello5')";

        for(int i=0;i<insertDB.length;i++){
            db.execSQL(insertDB[i]);
        }//for
    }//onCreate

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }//onUpgrade
}
