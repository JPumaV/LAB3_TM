package com.puma.laboratorio3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class SegundaActivity extends AppCompatActivity {

    protected static final int TIMER_RUNTIME = 10000;
    protected boolean nbActivo;
    protected ProgressBar nProgressBar;
    protected TextView txtEstado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        nProgressBar = findViewById(R.id.progressBar);
        txtEstado = findViewById(R.id.txtEstado);

        txtEstado.setText("Cargando...");

        final Thread timerThread = new Thread() {
            @Override
            public void run() {
                nbActivo = true;

                try {
                    int tiempo = 0;

                    while (nbActivo && tiempo < TIMER_RUNTIME) {
                        sleep(200);
                        tiempo += 200;
                        actualizarProgress(tiempo);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    onContinuar();
                }
            }
        };

        timerThread.start();
    }

    public void actualizarProgress(final int tiempo) {

        runOnUiThread(() -> {
            int progress = nProgressBar.getMax() * tiempo / TIMER_RUNTIME;
            nProgressBar.setProgress(progress);
        });
    }

    public void onContinuar() {

        runOnUiThread(() -> {
            txtEstado.setText("Carga completa");
            Toast.makeText(this, "Proceso terminado", Toast.LENGTH_SHORT).show();
        });

        Log.d("mensajeFinal", "Su barra de progreso acaba de cargar");
    }
}