package com.example.jh.mycalendar;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class ScheduleManagementActivity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.activity_schedule_management, container, false); // 여기서 UI를 생성해서 View를 return


        return  view;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getActivity().getMenuInflater().inflate(R.menu.schedulemenu, menu);
        Log.d("test", "onCreateOptionsMenu - 최초 메뉴키를 눌렀을 때 호출됨 ");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 메뉴의 항목을 선택(클릭)했을 때 호출되는 콜백메소드
        Log.d("test", "onOptionsItemSelected - 메뉴항목을 클릭했을 때 호출됨");

        int id=item.getItemId();

        switch (id) {
            case R.id.menu1:
                Toast.makeText(getActivity().getApplicationContext(), "완료 못한 일정만 보기", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu2:
                Toast.makeText(getActivity().getApplicationContext(), "추가", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu3:
                Toast.makeText(getActivity().getApplicationContext(), "삭제", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu4:
                Toast.makeText(getActivity().getApplicationContext(), "정렬", Toast.LENGTH_LONG).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
