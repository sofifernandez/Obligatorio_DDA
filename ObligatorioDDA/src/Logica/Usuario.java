/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.Objects;

/**
 *
 * @author sofia
 */
public abstract class Usuario {
    private String cedula;
    private String password;
    private String nombreCompleto;
    private boolean sesionIniciada;
    
    public Usuario(String cedula, String password) {
        this.cedula=cedula;
        this.password=password;
        sesionIniciada=false;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.cedula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.cedula, other.cedula);
    }
    
    
}
