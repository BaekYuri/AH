package com.example.jh.mycalendar;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class SchedulseeActivity extends Activity {

    ListView list;
    myDBHelper dbHelper;
    SQLiteDatabase db;
    String sql;
    Cursor cursor;
    int is_it_check,setcheck;
    final static String dbName = "CalendarDB.db";
    final static int dbVersion = 2;
    int index_num;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedulsee);

        list = (ListView)findViewById(R.id.list);
        dbHelper = new myDBHelper(this, dbName, null, dbVersion);

        selectDB();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cursor.moveToPosition(position);
                is_it_check=cursor.getInt(cursor.getColumnIndex("isitcheck"));
                if(is_it_check==0){
                    setcheck=1;
                }else{
                    setcheck=0;
                }
                index_num=cursor.getInt(cursor.getColumnIndex("_id"));
                String sql2="UPDATE ToDoList SET isitcheck="+setcheck+" where _id="+index_num+";";
                db.execSQL(sql2);
                selectDB();
            }
        });

    }

    private void selectDB(){
        db = dbHelper.getWritableDatabase();
        sql = "SELECT * FROM ToDoList ORDER BY year ASC, month ASC, day ASC, _id ASC;";

        cursor = db.rawQuery(sql, null);
        if(cursor.getCount() > 0){
            startManagingCursor(cursor);
            DBAdapter dbAdapter = new DBAdapter(this, cursor);
            list.setAdapter(dbAdapter);
        }
    }

}