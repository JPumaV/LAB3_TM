package com.puma.laboratorio3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irSegunda(View v){
        startActivity(new Intent(this, SegundaActivity.class));
    }

    public void irMoneda(View v){
        startActivity(new Intent(this, MonedaActivity.class));
    }

    public void irDrawer(View v){
        startActivity(new Intent(this, DrawerActivity.class));
    }
}