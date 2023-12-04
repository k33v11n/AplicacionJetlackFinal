package Jetlack.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GPS extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    private EditText txtlatitud, txtlongitud;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        // Inicialización de vistas
        txtlatitud = findViewById(R.id.txtlatitud);
        txtlongitud = findViewById(R.id.txtlongitud);

        // Configuración del mapa
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // Configuración del botón Atras
        Button btnAtrasGPS = findViewById(R.id.btnatrasgps);
        btnAtrasGPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Finaliza la actividad actual para retroceder
                finish();
            }
        });
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        // Configuración de clics en el mapa
        mMap.setOnMapClickListener(this);
        mMap.setOnMapLongClickListener(this);

        // Marcador inicial en Chile
        LatLng chile = new LatLng(-36.6124536, -72.1243113);
        mMap.addMarker(new MarkerOptions().position(chile).title("Chile"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(chile));
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        actualizarCoordenadas(latLng);
    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        actualizarCoordenadas(latLng);
    }

    // Método para actualizar las coordenadas en los EditText
    private void actualizarCoordenadas(LatLng latLng) {
        txtlatitud.setText(String.valueOf(latLng.latitude));
        txtlongitud.setText(String.valueOf(latLng.longitude));
    }
}