package com.sh_tab.shmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer mediaPlayer;
    String text = "I love you, slut!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Sheet", Toast.LENGTH_SHORT).show();
        findViewById(R.id.bt_safe).setOnClickListener(this);
        findViewById(R.id.bt_read).setOnClickListener(this);
        findViewById(R.id.bt_next).setOnClickListener(this);
        findViewById(R.id.bt_pause).setOnClickListener(this);
        findViewById(R.id.bt_prev).setOnClickListener(this);
        ((TextView)findViewById(R.id.hell_world)).setText("sheet");
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.bt_safe:
                safe_file();
                break;
            case R.id.bt_read:
                read_file();
                break;
            case R.id.bt_next:
                break;
            case R.id.bt_pause:
                break;
            case R.id.bt_prev:
                break;
            default:
                break;
        }
    }

    private File get_file_global_path(String file_name) {
        return new File(getExternalFilesDir(null), file_name);
    }

    private void safe_file() {
        try(FileOutputStream fos = new FileOutputStream(get_file_global_path("hell_world.txt"))) {
            //EditText textBox = findViewById(R.id.editor);
            //String text = textBox.getText().toString();
            fos.write(text.getBytes());
            Toast.makeText(this, "Готово", Toast.LENGTH_SHORT).show();
        }
        catch(IOException ex) {

            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void read_file() {
        File file = get_file_global_path("hell_world.txt");

        if(!file.exists()) return;
        try(FileInputStream fin =  new FileInputStream(file)) {
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String shhhh = new String (bytes);
            ((TextView)findViewById(R.id.hell_world)).setText(shhhh);
        }
        catch(IOException ex) {

            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}