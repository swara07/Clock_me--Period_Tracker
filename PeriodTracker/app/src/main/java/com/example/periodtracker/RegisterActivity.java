package com.example.periodtracker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class RegisterActivity extends AppCompatActivity {
    EditText name, email, duration, len_days;
    Button select_date;
    DatabaseHelper db;
    String din_date;
    Button sub;
    static int  num=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        duration=findViewById(R.id.duration);
        len_days=findViewById(R.id.length);
        select_date=findViewById(R.id.date);
        sub= findViewById(R.id.sub);
        db = new DatabaseHelper(this);



        select_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(RegisterActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        select_date.setText(day + "-" + (month + 1) + "-" + year);
                        din_date=select_date.getText().toString();

                    }
                }, year, month, day);
                datePickerDialog.show();


            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                String naam=name.getText().toString();
                String emaill=email.getText().toString();
                int len=Integer.parseInt(len_days.getText().toString());
                int dur=Integer.parseInt(duration.getText().toString());
                String din=din_date;
                num=1;
                db.addUser(naam,emaill,len,dur,din);


                SessionManagement ss=new SessionManagement(RegisterActivity.this);

                User user=new User(emaill);
                ss.savesaession(user);
                String n=ss.getSesion();
                String data_date=db.getdate(n);
                int d=db.getdur(n);
                Log.d("dddd",data_date);
                int dayy=Integer.parseInt(data_date.substring(0,2));
                int mon=Integer.parseInt(data_date.substring(3,4));
                int year=Integer.parseInt(data_date.substring(5));
                LocalDate date3 = LocalDate.of(year, mon, dayy).plusDays(d);


                //Adding number of Days to the given date
                Log.d("ddddddde",date3+"");
                setAlarm("hello",date3.toString(),"9:00");

                Intent homeIntent= new Intent(new Intent(RegisterActivity.this,navBar.class));
                startActivity(homeIntent);
                finish();

            }
        });







    }

    private void setAlarm(String text, String date, String time) {
        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(getApplicationContext(), AlarmBoardcast.class);
        intent.putExtra("event", text);
        intent.putExtra("time", date);
        intent.putExtra("date", time);
        String time1="9:22 AM";


        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, PendingIntent.FLAG_ONE_SHOT);
        String dateandtime = date + " " +time1.trim();

        DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd hh:mm");
        try {
            Date date1 = formatter.parse(dateandtime);
            //am.set(AlarmManager.RTC_WAKEUP, date1.getTime(), pendingIntent);
            am.set(AlarmManager.RTC_WAKEUP, date1.getTime() , pendingIntent) ;
            Log.d("gggg",date1.getTime()+" ");

        } catch (ParseException e) {
            e.printStackTrace();
        }

        finish();
    }
}