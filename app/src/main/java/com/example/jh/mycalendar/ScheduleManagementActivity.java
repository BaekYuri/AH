package com.example.jh.mycalendar;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;

public class ScheduleManagementActivity extends Fragment {

    ListView list;
    myDBHelper dbHelper;
    SQLiteDatabase db;
    String sql;
    Cursor cursor;
    int is_it_check,setcheck,index_num;
    final static String dbName = "CalendarDB.db";
    final static int dbVersion = 2;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.activity_schedule_management, container, false); // 여기서 UI를 생성해서 View를 return

        list = (ListView)view.findViewById(R.id.list);
        dbHelper = new myDBHelper(getActivity(), dbName, null, dbVersion);

        selectDB();

        Button buttonMenu = getActivity().findViewById(R.id.menu_btn);
        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupMenu p = new PopupMenu(
                        getActivity().getApplicationContext(), // 현재 화면의 제어권자
                        view); // anchor : 팝업을 띄울 기준될 위젯
                getActivity().getMenuInflater().inflate(R.menu.schedulemenu, p.getMenu());
                // 이벤트 처리
                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id=item.getItemId();
                        Intent intent;
                        switch (id) {
                            case R.id.menu1://완료못한일정
                                selectuncheckDB();
                                return true;
                            case R.id.menu2://추가
                                intent = new Intent(getActivity().getApplicationContext(), AdditionScheduleActivity.class);
                                startActivity(intent);
                                return true;
                            case R.id.menu3://삭제
                                return true;
                            case R.id.menu4://정렬
                                return true;
                        }
                        return false;
                    }
                });
                p.show(); // 메뉴를 띄우기
            }
        });

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

        return  view;
    }

    private void selectDB() {
        db = dbHelper.getWritableDatabase();
        sql = "SELECT * FROM ToDoList ORDER BY year ASC, month ASC, day ASC, _id ASC;";

        cursor = db.rawQuery(sql, null);
        if (cursor.getCount() > 0) {
            getActivity().startManagingCursor(cursor);
            DBAdapter dbAdapter = new DBAdapter(getActivity(), cursor);
            list.setAdapter(dbAdapter);
        }
    }
    private void selectuncheckDB() {
        db = dbHelper.getWritableDatabase();
        sql = "SELECT * FROM ToDoList WHERE isitcheck=0 ORDER BY year ASC, month ASC, day ASC, _id ASC;";

        cursor = db.rawQuery(sql, null);
        if (cursor.getCount() > 0) {
            getActivity().startManagingCursor(cursor);
            DBAdapter dbAdapter = new DBAdapter(getActivity(), cursor);
            list.setAdapter(dbAdapter);
        }
    }
    private void selectbdDB(){
        db = dbHelper.getWritableDatabase();
        sql = "SELECT * FROM ToDoList WHERE type = '기념일' ORDER BY year ASC, month ASC, day ASC, _id ASC;";

        cursor = db.rawQuery(sql, null);
        if(cursor.getCount() > 0){
            getActivity().startManagingCursor(cursor);
            DBAdapter dbAdapter = new DBAdapter(getActivity(), cursor);
            list.setAdapter(dbAdapter);
        }
    }
    private void selectdateDB(){
        db = dbHelper.getWritableDatabase();
        sql = "SELECT * FROM ToDoList WHERE type = '약속' ORDER BY year ASC, month ASC, day ASC, _id ASC;";

        cursor = db.rawQuery(sql, null);
        if(cursor.getCount() > 0){
            getActivity().startManagingCursor(cursor);
            DBAdapter dbAdapter = new DBAdapter(getActivity(), cursor);
            list.setAdapter(dbAdapter);
        }
    }
    private void selectschDB(){
        db = dbHelper.getWritableDatabase();
        sql = "SELECT * FROM ToDoList WHERE type ='학교' ORDER BY year ASC, month ASC, day ASC, _id ASC;";

        cursor = db.rawQuery(sql, null);
        if(cursor.getCount() > 0){
            getActivity().startManagingCursor(cursor);
            DBAdapter dbAdapter = new DBAdapter(getActivity(), cursor);
            list.setAdapter(dbAdapter);
        }
    }
    private void selectbizDB(){
        db = dbHelper.getWritableDatabase();
        sql = "SELECT * FROM ToDoList WHERE type ='회사' ORDER BY year ASC, month ASC, day ASC, _id ASC;";

        cursor = db.rawQuery(sql, null);
        if(cursor.getCount() > 0){
            getActivity().startManagingCursor(cursor);
            DBAdapter dbAdapter = new DBAdapter(getActivity(), cursor);
            list.setAdapter(dbAdapter);
        }
    }
    private void selecttripDB(){
        db = dbHelper.getWritableDatabase();
        sql = "SELECT * FROM ToDoList WHERE type ='여행' ORDER BY year ASC, month ASC, day ASC, _id ASC;";

        cursor = db.rawQuery(sql, null);
        if(cursor.getCount() > 0){
            getActivity().startManagingCursor(cursor);
            DBAdapter dbAdapter = new DBAdapter(getActivity(), cursor);
            list.setAdapter(dbAdapter);
        }
    }
    private void selectetcDB(){
        db = dbHelper.getWritableDatabase();
        sql = "SELECT * FROM ToDoList WHERE type ='기타' ORDER BY year ASC, month ASC, day ASC, _id ASC;";

        cursor = db.rawQuery(sql, null);
        if(cursor.getCount() > 0){
            getActivity().startManagingCursor(cursor);
            DBAdapter dbAdapter = new DBAdapter(getActivity(), cursor);
            list.setAdapter(dbAdapter);
        }
    }
}

