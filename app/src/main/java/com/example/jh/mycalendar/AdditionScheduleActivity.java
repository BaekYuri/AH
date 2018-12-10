package com.example.jh.mycalendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.util.Calendar;
public class AdditionScheduleActivity extends AppCompatActivity {
    Button delbutton, addbutton;
    EditText info;

    private int myear;
    private int mmonth;
    private int mday;
    private Button pickdate;
    RadioGroup type;
    RadioButton mtype1, mtype2, mtype3, mtype4, mtype5, mtype6;
    int a;
    static final int DATE_DIALOG_ID = 0;
    Button btnreturn;
    myDBHelper myHelper;
    SQLiteDatabase sqlDB;

    final static String dbName = "CalendarDB.db";
    final static int dbVersion = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition_schedule);

        addbutton=(Button) findViewById(R.id.addbutton);
        btnreturn=(Button) findViewById(R.id.btnReturn);


        pickdate = (Button) findViewById(R.id.pickdate);
        delbutton = (Button) findViewById(R.id.delbutton);
        info = (EditText) findViewById(R.id.info);
        type = (RadioGroup) findViewById(R.id.type);

        final Calendar c = Calendar.getInstance();

        myear = c.get(Calendar.YEAR);
        mmonth = c.get(Calendar.MONTH);
        mday = c.get(Calendar.DAY_OF_MONTH);
        pickdate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });

        mtype1 = (RadioButton) findViewById(R.id.type1);
        mtype2 = (RadioButton) findViewById(R.id.type2);
        mtype3 = (RadioButton) findViewById(R.id.type3);
        mtype4 = (RadioButton) findViewById(R.id.type4);
        mtype5 = (RadioButton) findViewById(R.id.type5);
        mtype6 = (RadioButton) findViewById(R.id.type6);

        mtype1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mtype1.setChecked(true);
                mtype2.setChecked(false);
                mtype3.setChecked(false);
                mtype4.setChecked(false);
                mtype5.setChecked(false);
                mtype6.setChecked(false);
                a= R.id.type1;
            }
        });

        mtype2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mtype2.setChecked(true);
                mtype1.setChecked(false);
                mtype3.setChecked(false);
                mtype4.setChecked(false);
                mtype5.setChecked(false);
                mtype6.setChecked(false);
                a= R.id.type2;
            }
        });
        mtype3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mtype3.setChecked(true);
                mtype2.setChecked(false);
                mtype1.setChecked(false);
                mtype4.setChecked(false);
                mtype5.setChecked(false);
                mtype6.setChecked(false);
                a= R.id.type3;
            }
        });
        mtype4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mtype4.setChecked(true);
                mtype2.setChecked(false);
                mtype3.setChecked(false);
                mtype1.setChecked(false);
                mtype5.setChecked(false);
                mtype6.setChecked(false);
                a= R.id.type4;
            }
        });
        mtype5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mtype5.setChecked(true);
                mtype2.setChecked(false);
                mtype3.setChecked(false);
                mtype4.setChecked(false);
                mtype1.setChecked(false);
                mtype6.setChecked(false);
                a= R.id.type5;
            }
        });
        mtype6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mtype6.setChecked(true);
                mtype2.setChecked(false);
                mtype3.setChecked(false);
                mtype4.setChecked(false);
                mtype5.setChecked(false);
                mtype1.setChecked(false);
                a= R.id.type6;
            }
        });

        myHelper = new myDBHelper(this, dbName, null, dbVersion);
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x;
                switch (a){
                    case R.id.type1:
                        x="기념일";
                        break;
                    case R.id.type2:
                        x="약속";
                        break;
                    case R.id.type3:
                        x="학교";
                        break;
                    case R.id.type4:
                        x="회사";
                        break;
                    case R.id.type5:
                        x="여행";
                        break;
                    default:
                        x="기타";
                }
                sqlDB = myHelper.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO ToDoList VALUES (null, 0, '" + myear + "', '"+(mmonth+1)+"', '"+mday+"', '" + info.getText().toString() + "','" + x + "');");
                sqlDB.close();
                Toast.makeText(getApplicationContext(),"추가되었습니다.",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AdditionScheduleActivity.this, SchedulseeActivity.class);
                startActivity(intent);
            }
        });
        delbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onBackPressed();
            }
        });
        btnreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
    private void updateDisplay() {
        pickdate.setText(new StringBuilder().append(myear).append("년 ").append(mmonth + 1).append("월 ").append(mday).append("일"));
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker View, int year, int monthOfYear, int dayOfMonth) {
            myear = year;
            mmonth = monthOfYear;
            mday = dayOfMonth;

            updateDisplay();

        }
    };

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, mDateSetListener, myear, mmonth, mday);
        }
        return null;
    }

}
