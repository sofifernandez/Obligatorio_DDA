/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion.Vistas;

import Logica.Crupier;
import Logica.Usuario;
import Presentacion.Controladores.LoginCrupierControlador;
import Presentacion.Vistas.Crupier.ConfigurarMesaVentana;


/**
 *
 * @author sofia
 */
public class LoginCrupier extends LoginVentana {
    
    public LoginCrupier() {
        this.setControlador(new LoginCrupierControlador(this));
    }

    @Override
    public void abrirSiguientePantalla(Usuario usuario) {
       new ConfigurarMesaVentana((Crupier) usuario).setVisible(true);
    }
    
}
