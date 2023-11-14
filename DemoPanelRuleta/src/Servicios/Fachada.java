/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import Logica.Crupier;
import Logica.Jugador;
import Logica.JugadorMesa;
import Logica.Mesa;
import Utilitarios.Observable;
import java.util.List;

/**
 *
 * @author sofia
 */
public class Fachada extends Observable {
    
    private ServicioUsuarios sUsuarios;
    //private ServicioCasilleros sCasilleros;
    private ServicioMesas sMesas;

    private static Fachada instancia;
    
    private Fachada() {
        sUsuarios = new ServicioUsuarios();
        //sCasilleros = new ServicioCasilleros();
        sMesas= new ServicioMesas();
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

    public Jugador loginJugador(String cedula, String password) {
        return sUsuarios.loginJugador(cedula, password);
    }

    public Crupier loginCrupier(String cedula, String password) {
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
   
    
}
