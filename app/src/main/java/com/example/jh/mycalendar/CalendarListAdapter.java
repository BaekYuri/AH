package com.example.jh.mycalendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class CalendarListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<CalendarListItem> item;
    private int layout;

    public CalendarListAdapter(Context context, ArrayList<CalendarListItem> item, int layout) {
        this.context = context;
        this.item = item;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return this.item.size();
    }

    @Override
    public Object getItem(int position){
        return this.item.get(position).getName();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(view==null){
            view=LayoutInflater.from(context).inflate(R.layout.item_calendar_list,null);
        }
        CalendarListItem listItem = item.get(position);
        CheckBox checkBox = (CheckBox)view.findViewById(R.id.checkBox);
        checkBox.setChecked(listItem.getCheck());

        TextView name=(TextView)view.findViewById(R.id.scheduleName);
        name.setText(listItem.getName());
        return view;
    }
}
