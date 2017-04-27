package org.androidtown.a20170418_lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    RadioButton r_man;
    RadioButton r_woman;
    CheckBox c_sms;
    CheckBox c_email;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.edit_name);
        r_man = (RadioButton)findViewById(R.id.man);
        r_woman = (RadioButton)findViewById(R.id.woman);
        c_sms = (CheckBox)findViewById(R.id.check_sms);
        c_email = (CheckBox)findViewById(R.id.check_email);

        button = (Button)findViewById(R.id.button);

//        When pressed Registration button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Make intent for send text to NewActivity!
                Intent intent = new Intent(getApplicationContext(), NewActivity.class);

//                putExtra name value
                intent.putExtra("name", editText.getText().toString());

//                putExtra gender value
                if(r_man.isChecked())
                {
                    intent.putExtra("gender", r_man.getText().toString());
                }
                else if(r_woman.isChecked())
                {
                    intent.putExtra("gender", r_woman.getText().toString());
                }


//                putExtra Receive way value
                if(c_sms.isChecked() && c_email.isChecked())
                {
                    intent.putExtra("receive", c_sms.getText().toString()+" & "+c_email.getText().toString());
                }
                else if(c_sms.isChecked())
                {
                    intent.putExtra("receive", c_sms.getText().toString());
                }
                else if(c_email.isChecked())
                {
                    intent.putExtra("receive", c_email.getText().toString());
                }

//                start NewActivity
                startActivity(intent);
                finish();
            }
        });
    }
}
