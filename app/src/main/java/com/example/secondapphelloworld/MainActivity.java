package com.example.secondapphelloworld;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void BeginAnew(View view)
    {
        Intent testIntent = new Intent(this,TestActivity02.class);
        startActivity(testIntent);
    }
}

