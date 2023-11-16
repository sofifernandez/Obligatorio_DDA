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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sofia
 */
public class LoginCrupierControlador extends LoginControlador {

    public LoginCrupierControlador(LoginVistaInterface vista) {
        super(vista);
        this.getVista().setearTitulo( "CRUPIERS");
    }
    

    @Override
    protected Usuario login(String usuario, String password) {
        try {
            return Fachada.getInstancia().loginCrupier(usuario, password);
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
