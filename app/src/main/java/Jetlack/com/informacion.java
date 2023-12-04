package Jetlack.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class informacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);

        Button btnIrAPantalla2 = findViewById(R.id.btnsiguienteinformacion);
        btnIrAPantalla2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(informacion.this, tipo_numero1.class);
                startActivity(intent);
            }
        });

        Button btnAtras = findViewById(R.id.btnatrasinformacion);
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Finaliza la actividad actual para retroceder
                finish();
            }
        });
    }
}