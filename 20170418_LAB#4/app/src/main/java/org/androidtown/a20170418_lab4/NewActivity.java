package org.androidtown.a20170418_lab4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Jiran on 2017-04-18.
 */

public class NewActivity extends AppCompatActivity {

    Button button;
    TextView textview;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

//        intent for get information from MainActivity
        Intent intent = getIntent();

//        get information
        String name = intent.getStringExtra("name");
        String gender = intent.getStringExtra("gender");
        String receive = intent.getStringExtra("receive");

//        Make String for TextView
        String info = "Name:\t\t\t\t"+name+"\nGender:\t\t\t"+gender+"\nReceive:\t\t\t"+receive;

        textview = (TextView)findViewById(R.id.new_view);

//        setText info
        textview.setText(info);

        button = (Button)findViewById(R.id.button_re);
//        When pressed Return button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplication(), MainActivity.class);

//                Start MainActivity
                startActivity(intent1);
                finish();
            }
        });
    }
}
