package com.example.jh.mycalendar;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CursorAdapter;
import android.widget.TextView;


public class DBAdapter extends CursorAdapter {
    boolean a;

    public DBAdapter(Context context, Cursor c) {
        super(context, c);

    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        final CheckBox checkBOX2 = (CheckBox) view.findViewById(R.id.schedulecheck);
        final TextView scheduleinfo = (TextView)view.findViewById(R.id.scheduleinfo);
        final TextView scheduletype = (TextView)view.findViewById(R.id.scheduletype);
        final TextView scheduledate = (TextView)view.findViewById(R.id.scheduledate);
        int year, month, day;
        boolean value = cursor.getInt(cursor.getColumnIndex("isitcheck"))>0;
        checkBOX2.setChecked(value);
        scheduleinfo.setText(cursor.getString(cursor.getColumnIndex("info")));
        scheduletype.setText(cursor.getString(cursor.getColumnIndex("type")));
        year = cursor.getInt(cursor.getColumnIndex("year"));
        month = cursor.getInt(cursor.getColumnIndex("month"));
        day = cursor.getInt(cursor.getColumnIndex("day"));
        scheduledate.setText(year+"년 "+month+"월 "+day+"일");


    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.scheduleitemlayout, parent, false);
        return v;
    }


}
