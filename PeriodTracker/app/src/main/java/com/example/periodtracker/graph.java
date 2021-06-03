package com.example.periodtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class graph extends AppCompatActivity {
    int list[]=new int[6];
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        GraphView scoregraph = (GraphView) findViewById(R.id.graph2);
        scoregraph.getGridLabelRenderer().setHorizontalAxisTitle("Days of the week");
        db=new DatabaseHelper(this);
        SessionManagement ss=new SessionManagement(graph.this);
        String n=ss.getSesion();
        list=db.graph_content(n);

        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(1,list[0]),
                new DataPoint(2,list[1]),
                new DataPoint(3, list[2]),
                new DataPoint(4, list[3]),
                new DataPoint(5, list[4]),
                new DataPoint(6,list[5]),
        });
        scoregraph.addSeries(series);
        //scoregraph.getViewport().setMinY(0);
        //scoregraph.getViewport().setMaxY(60);
        //scoregraph.getViewport().setYAxisBoundsManual(true);
        //scoregraph.getViewport().setScalableY(true);
        scoregraph.getGridLabelRenderer().setNumHorizontalLabels(6);
        scoregraph.getLegendRenderer().setBackgroundColor(Color.LTGRAY);

        scoregraph.setBackgroundColor(Color.WHITE);
        scoregraph.getLegendRenderer().setVisible(true);
        scoregraph.getViewport().setMinY(1);
        scoregraph.getViewport().setMaxY(10);
        scoregraph.getViewport().setScalableY(true);
        scoregraph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        series.setTitle("MOOD");
        series.setThickness(7);
        series.setColor(Color.BLUE);
        series.setAnimated(true);
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(10);

    }
}