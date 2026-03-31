package com.puma.laboratorio3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;

public class MonedaActivity extends AppCompatActivity {

    EditText txtSoles;
    TextView txtResultado, txtEstado;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moneda);

        txtSoles = findViewById(R.id.txtSoles);
        txtResultado = findViewById(R.id.txtResultado);
        txtEstado = findViewById(R.id.txtEstado);
        progressBar = findViewById(R.id.progressBar);
    }

    public void convertir(View v){

        txtEstado.setText("Procesando...");
        progressBar.setProgress(0);

        new Thread(() -> {
            try {
                Thread.sleep(2000);

                double soles = Double.parseDouble(txtSoles.getText().toString());
                double dolares = soles / 3.8;

                runOnUiThread(() -> {
                    progressBar.setProgress(100);
                    txtResultado.setText("Dólares: " + dolares);
                    txtEstado.setText("Carga completa");
                });

            } catch (Exception e){
                e.printStackTrace();
            }
        }).start();
    }
}