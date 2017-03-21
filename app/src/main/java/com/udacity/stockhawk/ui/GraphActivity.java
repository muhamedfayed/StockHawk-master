package com.udacity.stockhawk.ui;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.udacity.stockhawk.R;

public class GraphActivity extends AppCompatActivity {

    String stockname;

    String uri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        stockname = getIntent().getExtras().getString("stockname");

        uri = "content://com.udacity.stockhawkquote/"+stockname;

        Uri stockdata = Uri.parse(uri);

        Cursor c = getContentResolver().query(
                stockdata,
                null,
                null,
                null,
                null
        );

        if (c.moveToFirst()) {
            do{
                Log.i("graph",c.getColumnName(Integer.parseInt("price")));
                Log.i("graph",c.getColumnName(Integer.parseInt("symbol")));

            } while (c.moveToNext());
        }

    }
}
