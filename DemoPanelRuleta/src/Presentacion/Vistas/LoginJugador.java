/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion.Vistas;

import Logica.Jugador;
import Logica.Usuario;
import Presentacion.Controladores.LoginJugadorControlador;
import Presentacion.Vistas.Jugador.MesasDisponiblesVentana;


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
        System.out.println("Aca estoy");
        new MesasDisponiblesVentana((Jugador) usuario).setVisible(true);
        
    }
    
}
