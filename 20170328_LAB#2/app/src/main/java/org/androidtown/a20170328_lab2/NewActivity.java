package org.androidtown.a20170328_lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

//        Find Close button by ID.
        Button button2 = (Button) findViewById(R.id.button2);

//        When Close button clicked, do this function.
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
//                Floating a closing Toast message.
                Toast.makeText(getApplicationContext(), "Pressed Close Button", Toast.LENGTH_SHORT).show();

//               Send result value to Main Activity.
                Intent intent = new Intent();
                intent.putExtra("Closing", "Closed");
                setResult(RESULT_OK, intent);

//                Close New Activity.
                finish();
            }
        });
    }
}
