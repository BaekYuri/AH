package com.example.jh.mycalendar;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.listeners.OnDayClickListener;

import java.util.ArrayList;

public class CalendarActivity extends Fragment {
   CalendarView calendarView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.activity_calendar, container, false); // 여기서 UI를 생성해서 View를 return

        calendarView = view.findViewById(R.id.calendarView);
        ListView listView = view.findViewById(R.id.calendarList);
        TextView textView = view.findViewById(R.id.tv_click);
        LinearLayout linearLayout = view.findViewById(R.id.ll_list);
        calendarView.setSelected(false);
        calendarView.setOnDayClickListener(new OnDayClickListener() {
            @Override
            public void onDayClick(EventDay eventDay) {
                textView.setVisibility(View.GONE);
                linearLayout.setVisibility(View.VISIBLE);
            }
        });
        ArrayList<CalendarListItem> item = new ArrayList<>();
        item.add(new CalendarListItem(false,"저녁식사"));
        item.add(new CalendarListItem(true,"저녁식사"));
        item.add(new CalendarListItem(true,"저녁식사"));
        item.add(new CalendarListItem(false,"저녁식사"));
        item.add(new CalendarListItem(false,"저녁식사"));
        item.add(new CalendarListItem(true,"저녁식사"));
        item.add(new CalendarListItem(false,"저녁식사"));
        item.add(new CalendarListItem(true,"저녁식사"));
        item.add(new CalendarListItem(false,"저녁식사"));
        CalendarListAdapter adapter = new CalendarListAdapter(getActivity(),item,R.layout.item_calendar_list);
        listView.setAdapter(adapter);
        Button button = view.findViewById(R.id.deleteButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setVisibility(View.GONE);
                textView.setVisibility(View.VISIBLE);
                calendarView.setSelected(false);
            }
        });

        Button buttonPlus = getActivity().findViewById(R.id.plus_btn);
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), AdditionScheduleActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}