package com.example.gondolin.canalstatus;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import connection.CanalInformation;
import models.CanalData;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    static final long ONE_MINUTE_IN_MILLIS = 60000;//millisecs
    Spinner dropDown;
    TableLayout infoTable;
    CanalInformation canalInformation = new CanalInformation();
    TextView location;
    TextView cStatus;
    TextView nextBoat;
    TextView bound;
    TextView currentTime;
    TableRow stats;
    Button refresh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dropDown = (Spinner) findViewById(R.id.canalDropDown);
        infoTable = (TableLayout) findViewById(R.id.tableInformation);
        location = (TextView) findViewById(R.id.canalLocation);
        cStatus = (TextView) findViewById(R.id.canalStatus);
        nextBoat = (TextView) findViewById(R.id.nextBoat);
        currentTime = (TextView) findViewById(R.id.currentTime);
        bound = (TextView) findViewById(R.id.between);
        stats = (TableRow) findViewById(R.id.stats);
        refresh = (Button) findViewById(R.id.refresh);
        dropDown.setOnItemSelectedListener(this);
        refresh.setOnClickListener(this);
        setDropDown();
    }

    private void setDropDown() {
        List<String> dropDownValues = new ArrayList<>();
        dropDownValues.add("Select Bridge");
        for (CanalData current : canalInformation.getCanalInfromation()) {
            dropDownValues.add(current.getLocation());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, dropDownValues);
        dropDown.setAdapter(adapter);

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        refreshPage(i);
    }


    private void refreshPage(int i) {

        if (i == 0) {
            toggleInvisible(true);
        } else {
            toggleInvisible(false);
            setTable(i - 1);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @SuppressLint("SetTextI18n")
    public void setTable(int index) {

        @SuppressLint("SimpleDateFormat") SimpleDateFormat thClock = new SimpleDateFormat("hh:mm a");
        CanalData current = canalInformation.getCanalInfromation().get(index);
        location.setText(current.getLocation());
        //  location.setBackgroundColor(#);
        String status = current.getStatus().getStatus();

        if (status.contains("Un")) {
            stats.setBackgroundColor(Color.parseColor("#FA7C92"));
        } else {
            stats.setBackgroundColor(Color.parseColor("#66AB8C"));
        }
        cStatus.setText(status);

        if (current.getStatus().getNext() == null) {
            nextBoat.setText("No Boats Coming");
            bound.setText("go when you please");
        } else {

            String originalDate = current.getStatus().getNext();
            try {

                Date date = new SimpleDateFormat(
                        "yyyy-MM-dd'T'HH:mm:ss", Locale.US).parse(originalDate);
                String dateTime = thClock.format(date);
                nextBoat.setText(dateTime);

                Date lowerBound = new Date(date.getTime() - (5 * ONE_MINUTE_IN_MILLIS));
                Date upperBound = new Date(date.getTime() + (5 * ONE_MINUTE_IN_MILLIS));

                String dontGo = thClock.format(lowerBound) + " -" + thClock.format(upperBound);
                bound.setText(dontGo);
                currentTime.setText(dateTime);
            } catch (Exception e) {
                bound.setText("Internal Error. Tell Eduardo");
                nextBoat.setText("Internal Error. Tell Eduardo");
            }
        }

    }

    private void toggleInvisible(Boolean visible) {
        if (visible) {
            setVisibility(View.INVISIBLE);
        } else {
            setVisibility(View.VISIBLE);
        }
    }

    private void setVisibility(int visibility) {
        location.setVisibility(visibility);
        infoTable.setVisibility(visibility);
        refresh.setVisibility(visibility);
        currentTime.setVisibility(visibility);
    }

    @Override
    public void onClick(View view) {
        refreshPage(dropDown.getSelectedItemPosition());
    }
}
