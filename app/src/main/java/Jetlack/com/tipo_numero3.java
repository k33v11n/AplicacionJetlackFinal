package Jetlack.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tipo_numero3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_numero3);

        Button btnIrAPantalla2 = findViewById(R.id.btnsiguientetipo3);
        btnIrAPantalla2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tipo_numero3.this, contador.class);
                startActivity(intent);
            }
        });

        Button btnAtras = findViewById(R.id.btnatrastipo3);
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Finaliza la actividad actual para retroceder
                finish();
            }
        });
    }
}