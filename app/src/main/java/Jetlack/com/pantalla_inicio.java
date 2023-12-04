package Jetlack.com;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class pantalla_inicio extends AppCompatActivity {
    private TextView textViewTimer;
    private Button btnStart;

    private boolean isRunning = false;
    private long startTime = 0L;
    private Handler handler = new Handler();
    private long elapsedTime = 0L;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicio);
        Button btnIrAPantalla2 = findViewById(R.id.btnsiguientecronometro);
        btnIrAPantalla2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pantalla_inicio.this, informacion.class);
                startActivity(intent);
            }
        });
        Button btnAtras = findViewById(R.id.btnatrascronometro);
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Finaliza la actividad actual para retroceder
                finish();
            }
        });
        textViewTimer = findViewById(R.id.tiempo);
        btnStart = findViewById(R.id.btniniciar);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isRunning) {
                    startTimer();
                    btnStart.setText("Detener");
                } else {
                    stopTimer();
                    btnStart.setText("Iniciar");
                }
            }
        });
    }

    private void startTimer() {
        startTime = SystemClock.uptimeMillis();
        handler.postDelayed(updateTimer, 0);
        isRunning = true;
    }

    private void stopTimer() {
        handler.removeCallbacks(updateTimer);
        isRunning = false;
    }

    private Runnable updateTimer = new Runnable() {
        public void run() {
            elapsedTime = SystemClock.uptimeMillis() - startTime;
            int seconds = (int) (elapsedTime / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;

            String time = String.format("%d:%02d", minutes, seconds);
            textViewTimer.setText(time);

            if (minutes == 1) {
                // Detener el cronómetro después de 1 minuto
                stopTimer();
                btnStart.setText("Iniciar");
            } else {
                handler.postDelayed(this, 500); // Actualizar cada 500 milisegundos
            }
        }

    };

}