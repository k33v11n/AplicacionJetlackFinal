package Jetlack.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tipo_numero2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_numero2);

        Button btnIrAPantalla2 = findViewById(R.id.btnsiguientetipo2);
        btnIrAPantalla2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tipo_numero2.this, tipo_numero3.class);
                startActivity(intent);
            }
        });

        Button btnAtras = findViewById(R.id.btnatrastipo2);
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Finaliza la actividad actual para retroceder
                finish();
            }
        });


    }
}