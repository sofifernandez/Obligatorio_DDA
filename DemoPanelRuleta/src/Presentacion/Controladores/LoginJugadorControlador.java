/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion.Controladores;

import Excepciones.SesionYaIniciadaException;
import Excepciones.UsuarioInvalidoException;
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
        try{ 
            Usuario u= Fachada.getInstancia().loginJugador(usuario, password); 
            return u;
        
       } catch (UsuarioInvalidoException | SesionYaIniciadaException ex ) {
            this.getVista().mostrarError(ex.getMessage());
        } 
        
        return null;
            
    }

    @Override
    protected void ejecutarProximoCasoDeUso(Usuario usuario) {
        this.getVista().abrirSiguientePantalla(usuario);
    }
    
}
