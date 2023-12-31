/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import Excepciones.SesionYaIniciadaException;
import Excepciones.UsuarioInvalidoException;
import Logica.Crupier;
import Logica.Efecto;
import Logica.Jugador;
import Logica.JugadorMesa;
import Logica.Mesa;
import Logica.TipoApuesta;
import Logica.Usuario;
import Utilitarios.Observable;
import java.util.List;

/**
 *
 * @author sofia
 */
public class Fachada extends Observable {
    
    private ServicioUsuarios sUsuarios;
    private ServicioMesas sMesas;
    private ServicioTiposApuesta sTiposAp;
    private ServicioEfectos sEfectos;

    private static Fachada instancia;
    
    private Fachada() {
        sUsuarios = new ServicioUsuarios();
        //sCasilleros = new ServicioCasilleros();
        sMesas= new ServicioMesas();
        sTiposAp= new ServicioTiposApuesta();
        sEfectos= new ServicioEfectos();
    }

    public static Fachada getInstancia() {
        if(instancia == null)
            instancia = new Fachada();
        
        return instancia;
    }

    public void agregar(Jugador jugador) {
        sUsuarios.agregar(jugador);
       
    }

    public void agregar(Crupier crupier) {
        sUsuarios.agregar(crupier);
    }

    public Jugador loginJugador(String cedula, String password) throws UsuarioInvalidoException, SesionYaIniciadaException {
        return sUsuarios.loginJugador(cedula, password);
    }

    public Crupier loginCrupier(String cedula, String password) throws UsuarioInvalidoException, SesionYaIniciadaException {
        return sUsuarios.loginCrupier(cedula, password);
    }
    
     public void agregar(Mesa mesa) {
        sMesas.agregar(mesa);
    }

    public List<Mesa> obtenerMesasDisponibles() {
        return sMesas.obtenerMesasDisponibles();
    }

    public void agregarJugadorMesaAMesa(JugadorMesa jugador, Mesa mesa) {
        sMesas.agregarJugadorMesaAMesa(jugador, mesa);
    }

    public void agregar(TipoApuesta tipo) {
        sTiposAp.agregar(tipo);
    }

    public ServicioTiposApuesta getsTiposAp() {
        return sTiposAp;
    }

    public void setsTiposAp(ServicioTiposApuesta sTiposAp) {
        this.sTiposAp = sTiposAp;
    }

    public void setDisponibles() {
        sMesas.setDisponibles();
    }

    public List<TipoApuesta> getTipos() {
        return sTiposAp.getTipos();
    }

    public void agregar(Efecto efecto) {
        sEfectos.agregar(efecto);
    }

    public void eliminar(Efecto efecto) {
        sEfectos.eliminar(efecto);
    }

    public List<Efecto> getEfectos() {
        return sEfectos.getEfectos();
    }

    public void logout(Usuario usuario) {
        sUsuarios.logout(usuario);
    }
    
    
    
   
    
    
    
    
}
