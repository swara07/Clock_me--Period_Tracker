package com.example.periodtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class register extends AppCompatActivity {
    EditText name, email, duration, len_days;
    Button select_date,submitt;
    DatabaseHelper db;
    String din_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        duration=findViewById(R.id.duration);
        len_days=findViewById(R.id.length);
        select_date=findViewById(R.id.date);
        submitt.findViewById(R.id.save);
        db = new DatabaseHelper(this);


        select_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(register.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        select_date.setText(day + "-" + (month + 1) + "-" + year);
                        din_date=select_date.getText().toString();

                    }
                }, year, month, day);
                datePickerDialog.show();


            }
        });

        submitt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String naam=name.getText().toString();
                String emaill=email.getText().toString();
                int len=Integer.parseInt(len_days.getText().toString());
                int dur=Integer.parseInt(duration.getText().toString());
                String din=din_date;

                db.addUser(naam,emaill,len,dur,din);

            }
        });
    }
}