package com.softvider.androiddeeplink;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView viewPath = findViewById(R.id.path);
        TextView viewToken = findViewById(R.id.token);

        // sample deep link => http://androiddeeplink.com/mobile_app?token=eyxxxxxxx
        Intent intent = getIntent();
        String action = intent.getAction();
        Uri data = intent.getData();
        if(data != null){
            String path = data.getPath();
            String token = data.getQueryParameter("token");
            viewPath.setText(path);
            viewToken.setText(token);
        }
    }
}