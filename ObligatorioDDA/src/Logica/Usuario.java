/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author sofia
 */
public abstract class Usuario {
    private String cedula;
    private String password;
    private String nombreCompleto;
    
    public Usuario(String cedula, String password) {
        this.cedula=cedula;
        this.password=password;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    
    public boolean isCedulaAndPassword(String cedula,String password) {
        return cedula!=null && password!=null && 
                this.password.equals(password) && 
                this.cedula.equals(cedula);
    }
}
