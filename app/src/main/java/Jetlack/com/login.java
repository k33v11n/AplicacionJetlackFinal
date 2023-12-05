package Jetlack.com;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class login extends AppCompatActivity {
    // Referencia a la base de datos de Firebase
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inicializar la referencia a la base de datos de Firebase
        databaseReference = FirebaseDatabase.getInstance().getReference("usuarios");

        Button btnIrAPantalla2 = findViewById(R.id.btningresarlogin);
        Button btnRegistrar = findViewById(R.id.btnregistrar);

        btnIrAPantalla2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, pantalla_inicio.class);
                startActivity(intent);
            }
        });

        // Manejar el evento de clic en el botón de registro
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener referencias a los campos de texto
                EditText nombreEditText = findViewById(R.id.txtnombre);
                EditText contraseñaEditText = findViewById(R.id.txtcontraseña);

                // Obtener los valores ingresados por el usuario
                String nombre = nombreEditText.getText().toString();
                String contraseña = contraseñaEditText.getText().toString();

                // Verificar que los campos no estén vacíos
                if (!nombre.isEmpty() && !contraseña.isEmpty()) {
                    // Crear un nuevo objeto Usuario con los datos ingresados
                    Usuario usuario = new Usuario(nombre, contraseña);

                    // Enviar el objeto Usuario a Firebase
                    databaseReference.child(nombre).setValue(usuario);

                    // Puedes agregar aquí lógica adicional, como mostrar un mensaje de éxito
                }
            }
        });
    }
}
