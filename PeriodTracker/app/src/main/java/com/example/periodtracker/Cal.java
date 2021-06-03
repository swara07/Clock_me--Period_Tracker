package com.example.periodtracker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Cal extends AppCompatActivity {
    CompactCalendarView compactCalendar;
    DatabaseHelper db;

    private SimpleDateFormat dateFormatMonth=new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal);
        final ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setTitle(null);
        db = new DatabaseHelper(this);





        compactCalendar=(CompactCalendarView) findViewById(R.id.compactcalendar_view);
        compactCalendar.setUseThreeLetterAbbreviation(true);

        Event ev1=new Event(Color.RED,86400000 , "Periods Day");
        compactCalendar.addEvent(ev1);
        compactCalendar.setEventIndicatorStyle(Color.WHITE);





            compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                Context context=getApplicationContext();
                Log.d("hello",dateClicked.toString());

                if (dateClicked.toString().compareTo("Sat Mar 20 00:00:00 GMT+05:30 2021")==0){
                    Toast.makeText(context,"Periods Day",Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(context," No Periods Day",Toast.LENGTH_SHORT).show();
                }

            }



            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                actionBar.setTitle(dateFormatMonth.format(firstDayOfNewMonth));
            }
        });




    }

//    private void setAlarm(String text, String date, String time) {
//        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//        Intent intent = new Intent(getApplicationContext(), AlarmBoardcast.class);
//        intent.putExtra("event", text);
//        intent.putExtra("time", date);
//        intent.putExtra("date", time);
//        String time1="9:22 AM";
//
//
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, PendingIntent.FLAG_ONE_SHOT);
//        String dateandtime = date + " " +time1.trim();
//
//        DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd hh:mm");
//        try {
//            Date date1 = formatter.parse(dateandtime);
//            //am.set(AlarmManager.RTC_WAKEUP, date1.getTime(), pendingIntent);
//            am.set(AlarmManager.RTC_WAKEUP, date1.getTime() , pendingIntent) ;
//            Log.d("gggg",date1.getTime()+" ");
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        finish();
//    }
}
