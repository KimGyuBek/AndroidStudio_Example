package com.example.customnaviexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private View drawerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawerView = (View)findViewById(R.id.drawer);

        Button btn_open = (Button) findViewById(R.id.btn_open);
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(drawerView); //눌렀을때 navi가 열린다
            }
        });

        drawerLayout.setDrawerListener(listener);
        drawerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        Button btn_close = (Button)findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {//close button을 눌렀을때 동작
            @Override
            public void onClick(View v) {
               drawerLayout.closeDrawers();
            }
        });

    }
    DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() { //drawer layout slide 했을때 호출됨
        //특정 action일때 추가 기능을 하고자 할 때

        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) { //slide 했을때

        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {//open

        }

        @Override
        public void onDrawerClosed(@NonNull View drawerView) {//close

        }

        @Override
        public void onDrawerStateChanged(int newState) {//status changed

        }
    };
}