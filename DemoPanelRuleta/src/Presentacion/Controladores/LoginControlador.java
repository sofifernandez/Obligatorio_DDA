/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion.Controladores;

import Logica.Usuario;
import Presentacion.Interfaces.LoginVistaInterface;

/**
 *
 * @author sofia
 */
public abstract class LoginControlador {
    
    private LoginVistaInterface vista;
    
    public LoginControlador(LoginVistaInterface vista) {
        this.vista = vista;
        //this.vista.setearTitulo("?");
    }
    
        public LoginVistaInterface getVista() {
        return vista;
    }
        
    public void usuarioIntentaIngresar(String userName, String password) {
        Usuario usuario = this.login(userName, password);
        if(usuario != null) {
            this.ejecutarProximoCasoDeUso(usuario);
            this.vista.cerrar();
        } 
    }
    
    protected abstract Usuario login(String usuario, String password);
    
    protected abstract void ejecutarProximoCasoDeUso(Usuario usuario);
    
    public void cerrar() {
        this.vista.cerrar();
    }
    
}
