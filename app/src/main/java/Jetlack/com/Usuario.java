package Jetlack.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Usuario {
    private String nombre;
    private String contraseña;

    // Constructor vacío requerido para Firebase
    public Usuario() {
    }

    public Usuario(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    // Getters y setters (puedes generarlos automáticamente en Android Studio)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
