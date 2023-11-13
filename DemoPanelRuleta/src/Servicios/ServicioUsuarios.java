/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import Logica.Crupier;
import Logica.Jugador;
import Logica.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sofia
 */
public class ServicioUsuarios {
    List<Jugador> jugadores;
    List<Crupier> crupiers;
    //List<Sesion> sesionesActivas;

    public ServicioUsuarios() {
        jugadores = new ArrayList();
        crupiers = new ArrayList();
        //sesionesActivas = new ArrayList();
    }

    public void agregar(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void agregar(Crupier crupier) {
        crupiers.add(crupier);
    }
    
    public Jugador loginJugador(String cedula, String password) {
        return (Jugador) login(cedula, password, (List) jugadores);
    }
    
    public Crupier loginCrupier(String cedula, String password) {
        return (Crupier) login(cedula, password, (List) crupiers);
    }
    
    private Usuario login(String cedula, String password, List<Usuario> listaUsuarios) {
        for (Usuario u : listaUsuarios) {
            if (u.isCedulaAndPassword(cedula, password)) {
                return u;
            }
        }
        return null;
    }
    

    

    /*
    public Sesion loginUsuarioAgenda(String nombreUsuario, String password) {
        UsuarioAgenda usuario = (UsuarioAgenda) login(nombreUsuario, password, (List) usuariosAgenda);
        if (usuario != null) {
            // Inicio sesion
            Sesion sesion = new Sesion(usuario);
            sesionesActivas.add(sesion);
            Fachada.getInstancia().notificar(Observador.Evento.SESION_HA_CAMBIADO);
            return sesion;
        }
        return null;
    }
    
    public List<Sesion> getSesionesActivas() {
        return sesionesActivas;
    }
    
    public void logout(Sesion sesion) {
        sesionesActivas.remove(sesion);
        Fachada.getInstancia().notificar(Observador.Evento.SESION_HA_CAMBIADO);
    }
    
    public UsuarioAdministrador loginUsuarioAdministrador(String nombreUsuario, String password) {
        return (UsuarioAdministrador) login(nombreUsuario, password, (List) usuariosAdministradores);
    }
*/
    
}
