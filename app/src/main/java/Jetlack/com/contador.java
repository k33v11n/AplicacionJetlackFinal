package Jetlack.com;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class contador extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor accelerometer;
    private TextView stepCountTextView;

    private int stepCount = 0;
    private boolean isStepCounting = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador);

        // Inicialización de vistas
        stepCountTextView = findViewById(R.id.stepCountTextView);

        // Inicialización del sensor y registro del listener
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager != null) {
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            if (accelerometer != null) {
                sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
                isStepCounting = true;
            } else {
                // El dispositivo no tiene acelerómetro
                isStepCounting = false;
            }
        }

        // Configuración de botones
        setupButtons();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (isStepCounting) {
            float[] values = event.values;
            float x = values[0];
            float y = values[1];
            float z = values[2];

            // Puedes ajustar estos valores según sea necesario para tu dispositivo
            float accelerationSquareRoot = (x * x + y * y + z * z) / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);

            if (accelerationSquareRoot >= 3) {
                // Se detectó un paso
                stepCount++;
                updateStepCount();
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // No necesitamos hacer nada aquí
    }

    private void updateStepCount() {
        runOnUiThread(() -> stepCountTextView.setText("Pasos: " + stepCount));
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isStepCounting) {
            sensorManager.unregisterListener(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isStepCounting) {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    private void setupButtons() {
        Button btnIrAPantalla2 = findViewById(R.id.btnsiguientecontador);
        btnIrAPantalla2.setOnClickListener(view -> {
            Intent intent = new Intent(contador.this, GPS.class);
            startActivity(intent);
        });

        Button btnAtras = findViewById(R.id.btnatrascontador);
        btnAtras.setOnClickListener(view -> finish());
    }
}
