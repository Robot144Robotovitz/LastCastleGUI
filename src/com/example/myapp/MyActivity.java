package com.example.myapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.TextView;
import com.example.myapp.R;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;
import android.view.MenuItem;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;



public class MyActivity extends Activity {

    NumberPicker np1,np2,np3,np4;
    TextView tv1, tv2, tv3, tv4, Day, Food, Science;
    AlertDialog.Builder ad,ad1;
    Context context;
    Button b1;
    int day = 0, fd = 0, sc = 0;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //int day, sc, fd;


        context = MyActivity.this;
        String title = "End day";
        String message = "You sure you want to end this day?";
        String button1String = "Yes";
        String button2String = "No";

        ad = new AlertDialog.Builder(context);
        ad1 = new AlertDialog.Builder(context);

        ad1.setTitle("What happened");

        ad.setTitle(title);  // заголовок
        ad.setMessage(message); // сообщение

        Day = (TextView) findViewById(R.id.Day);
        Food = (TextView) findViewById(R.id.Food);
        Science = (TextView) findViewById(R.id.Science);

        np1 = (NumberPicker) findViewById(R.id.numberPicker1);
        tv1 = (TextView) findViewById(R.id.textView1);
        //tv2 = (TextView) findViewById(R.id.textView3);

        np2 = (NumberPicker) findViewById(R.id.numberPicker2);
        tv2 = (TextView) findViewById(R.id.textView2);
        //tv22 = (TextView) findViewById(R.id.textView22);

        np3 = (NumberPicker) findViewById(R.id.numberPicker3);
        tv3 = (TextView) findViewById(R.id.textView3);

        np4 = (NumberPicker) findViewById(R.id.numberPicker4);
        tv4 = (TextView) findViewById(R.id.textView4);

        np1.setMinValue(0);
        np1.setMaxValue(10);
        np1.setWrapSelectorWheel(false);

        np2.setMinValue(0);
        np2.setMaxValue(10);
        np2.setWrapSelectorWheel(false);

        np3.setMinValue(0);
        np3.setMaxValue(10);
        np3.setWrapSelectorWheel(false);

        np4.setMinValue(0);
        np4.setMaxValue(10);
        np4.setWrapSelectorWheel(false);

        ad.setPositiveButton(button1String, new OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                Toast.makeText(context, "Another day passed",
                        Toast.LENGTH_LONG).show();

                day++;
                sc++;
                fd++;

                ad1.setMessage("Today we gained:\n " + fd + " of food\n" + sc + " of science");
                ad1.show();
                Science.setText("Science " + sc);
                Food.setText("Food" + fd);
                Day.setText("Day " + day);

            }
        });

        ad.setNegativeButton(button2String, new OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                Toast.makeText(context, "Возможно вы правы", Toast.LENGTH_LONG)
                        .show();
            }
        });
        ad.setCancelable(true);
        ad.setOnCancelListener(new OnCancelListener() {
            public void onCancel(DialogInterface dialog) {
                Toast.makeText(context, "Вы ничего не выбрали",
                        Toast.LENGTH_LONG).show();
            }
        });

        b1=(Button)findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "YOUR MESSAGE", Toast.LENGTH_LONG).show();
                ad.show();

            }


        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}


