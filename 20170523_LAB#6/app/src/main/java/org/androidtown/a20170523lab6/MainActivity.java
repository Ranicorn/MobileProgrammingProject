package org.androidtown.a20170523lab6;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

//    Declare values
    EditText edit;
    Button write;
    Button clear;
    Button read;
    Button reset;
    Button finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = (EditText)findViewById(R.id.editTxt);

        write = (Button)findViewById(R.id.write);
//        When press 1. WRITE SD FILE button, then write in SD file from EditText.
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = edit.getText().toString();

                try{
                    File sdcard = Environment.getExternalStorageDirectory();
                    File file = new File(sdcard, "mySDfile.txt");
                    file.createNewFile();
                    FileOutputStream fOut = new FileOutputStream(file, true);
                    OutputStreamWriter out = new OutputStreamWriter(fOut);
                    out.append(str);
                    out.close();
                    fOut.close();

                }catch (Exception e){
//                    When occur an exception, toast error message.
                    Toast.makeText(getApplicationContext(), "ERROR writing SD 'mySDfile.txt'", Toast.LENGTH_SHORT).show();
                }
//                When finish the process, toast done message.
                Toast.makeText(getApplicationContext(), "Done writing SD 'mySDfile.txt'", Toast.LENGTH_SHORT).show();
            }
        });

        clear = (Button)findViewById(R.id.clear);
//        When press 2. CLEAR SCREEN button, then clear EditText content and show hint.
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.setText("");
                edit.setHint("Enter some lines of data here...");

//                When finish the process, toast done message.
                Toast.makeText(getApplicationContext(), "Done clear screen", Toast.LENGTH_SHORT).show();
            }
        });

        read = (Button)findViewById(R.id.read);
//        When press 3. READ SD FILE button, then read from SD file and show in EditText.
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    File sdcard = Environment.getExternalStorageDirectory();
                    File file = new File(sdcard,"mySDfile.txt");

                    StringBuilder str = new StringBuilder();

                        BufferedReader br = new BufferedReader(new FileReader(file));
                        String line;

                        while ((line = br.readLine()) != null) {
                            str.append(line);
                            str.append('\n');
                        }
                        br.close();

                    edit.setText(str);

                }catch (Exception e){
//                    When occur an exception, toast error message.
                    Toast.makeText(getApplicationContext(), "ERROR reading SD 'mySDfile.txt'", Toast.LENGTH_SHORT).show();
                }
//                When finish the process, toast done message.
                Toast.makeText(getApplicationContext(), "Done reading SD 'mySDfile.txt'", Toast.LENGTH_SHORT).show();
            }
        });

        reset = (Button)findViewById(R.id.reset);
//        When press 4. RESET SD FILE button, then clear SD file.
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    File sdcard = Environment.getExternalStorageDirectory();
                    File file = new File(sdcard, "mySDfile.txt");
                    file.createNewFile();

                    FileOutputStream fOut = new FileOutputStream(file);
                    OutputStreamWriter out = new OutputStreamWriter(fOut);
                    out.append("");
                    out.close();
                    fOut.close();

                }catch (Exception e)
                {
//                    When occur an exception, toast error message.
                    Toast.makeText(getApplicationContext(), "ERROR resetting SD 'mySDfile.txt'", Toast.LENGTH_SHORT).show();
                }
//                When finish the process, toast done message.
                Toast.makeText(getApplicationContext(), "Done resetting SD 'mySDfile.txt'", Toast.LENGTH_SHORT).show();
            }
        });

        finish = (Button)findViewById(R.id.finish);
//        When press 5. FINISH APP button, then close app.
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Before close the app, toast finish message.
                Toast.makeText(getApplicationContext(), "Finish APP", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}
