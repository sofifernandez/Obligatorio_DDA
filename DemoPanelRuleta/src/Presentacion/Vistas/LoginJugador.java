/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion.Vistas;

import Logica.Usuario;
import Presentacion.Controladores.LoginJugadorControlador;
import javax.swing.JOptionPane;

/**
 *
 * @author sofia
 */
public class LoginJugador extends LoginVentana {
    
    public LoginJugador() {
        this.setControlador(new LoginJugadorControlador(this));
    }

    @Override
    public void abrirSiguientePantalla(Usuario usuario) {
        //la ventana que sea
         JOptionPane.showMessageDialog(this, usuario);
    }
    
}
