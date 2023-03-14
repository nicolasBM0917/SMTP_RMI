package Prueba1;

import java.io.Serializable;

public class rmi1 implements Serializable {

    private String nombre;
    private String email;
    private String telefono;
    private String contra;

    public rmi1(String nombre, String email, String telefono, String contra) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.contra = contra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCell() {
        return telefono;
    }

    public void setCell(String telefono) {
        this.telefono = telefono;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

}
