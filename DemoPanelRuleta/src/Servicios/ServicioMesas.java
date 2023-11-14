/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import Logica.Casillero;
import Logica.JugadorMesa;
import Logica.Mesa;
import Utilitarios.Observador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sofia
 */
public class ServicioMesas {
     List<Mesa> mesas;
     List<Mesa> mesasDisponibles;
     

    public ServicioMesas() {
        mesas = new ArrayList();
        mesasDisponibles=obtenerMesasDisponibles();
    }

    public void agregar(Mesa mesa) {
        mesas.add(mesa);
        Fachada.getInstancia().notificar(Observador.Evento.LISTADO_MESAS_MODIFICADO);
    }
    
    public void eliminar (Mesa mesa){
        mesas.remove(mesa);
        Fachada.getInstancia().notificar(Observador.Evento.LISTADO_MESAS_MODIFICADO);
    }
    
    public List<Mesa> obtenerMesasDisponibles(){
        mesasDisponibles=new ArrayList();
        for(Mesa m: mesas){
            if(m.esDisponible()) mesasDisponibles.add(m);
        } 
        //Fachada.getInstancia().notificar(Observador.Evento.LISTADO_MESAS_MODIFICADO);
        return mesasDisponibles;
    }
    
    public void setDisponibles(){
        mesasDisponibles=obtenerMesasDisponibles();
        Fachada.getInstancia().notificar(Observador.Evento.LISTADO_MESAS_MODIFICADO);
    }
    
    public void agregarJugadorMesaAMesa(JugadorMesa jugador, Mesa mesa){
        mesa.agregarJugadorMesa(jugador);
    }
    
    //FALTA ELIMINAR, DE CUANDO SE CIERRA UNA MESA
}
