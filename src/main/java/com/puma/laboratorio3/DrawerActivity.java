package com.puma.laboratorio3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ProgressBar;

public class DrawerActivity extends AppCompatActivity {

    ProgressBar progressBar;
    TextView txtEstado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        progressBar = findViewById(R.id.progressBar);
        txtEstado = findViewById(R.id.txtEstado);

        txtEstado.setText("Cargando Drawer...");

        new Thread(() -> {
            try {
                Thread.sleep(3000);

                runOnUiThread(() -> {
                    progressBar.setProgress(100);
                    txtEstado.setText("Carga completa");
                });

            } catch (Exception e){}
        }).start();
    }
}