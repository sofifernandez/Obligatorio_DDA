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

    public ServicioMesas() {
        mesas = new ArrayList();
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
        List<Mesa> mesasDisponibles = new ArrayList();
        for(Mesa m: mesas){
            if(m.esDisponible()) mesasDisponibles.add(m);
        } 
        return mesasDisponibles;
    }
    
    public void agregarJugadorMesaAMesa(JugadorMesa jugador, Mesa mesa){
        mesa.agregarJugadorMesa(jugador);
    }
    
    //FALTA ELIMINAR, DE CUANDO SE CIERRA UNA MESA
}
