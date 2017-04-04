package org.androidtown.a20170328_lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Name;
    EditText Age;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Find Name, Age and Add button by ID.
        Name = (EditText) findViewById(R.id.text1);
        Age = (EditText) findViewById(R.id.text2);
        button1 = (Button) findViewById(R.id.button1);

//        When Add button clicked, do this function.
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
//                Convert Name and Age text to String.
                String name = Name.getText().toString();
                String age = Age.getText().toString();

//                Start New Acticivity
                Intent intent = new Intent(getApplicationContext(), NewActivity.class);
                startActivity(intent);

//                Floating a Toast message with Name and Age values.
                Toast.makeText(getApplicationContext(), "Student info: "+name+" , "+age, Toast.LENGTH_SHORT).show();
            }
        });
    }

//  Receive result value from New Activity.
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        String out = data.getStringExtra("Closing");
        Toast.makeText(getApplicationContext(), ""+out, Toast.LENGTH_LONG).show();
    }
}
