/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion.Controladores;

import Logica.Usuario;
import Presentacion.Interfaces.LoginVistaInterface;
import Servicios.Fachada;

/**
 *
 * @author sofia
 */
public class LoginJugadorControlador extends LoginControlador{

    public LoginJugadorControlador(LoginVistaInterface vista) {
        super(vista);
        this.getVista().setearTitulo( "JUGADORES");
    }
    
    @Override
    protected Usuario login(String usuario, String password) {
        return Fachada.getInstancia().loginJugador(usuario, password);
    }

    @Override
    protected void ejecutarProximoCasoDeUso(Usuario usuario) {
        this.getVista().abrirSiguientePantalla(usuario);
    }
    
}
