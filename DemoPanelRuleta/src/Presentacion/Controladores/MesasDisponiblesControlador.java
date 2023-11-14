/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion.Controladores;

import Logica.Jugador;
import Logica.JugadorMesa;
import Logica.Mesa;
import Presentacion.Interfaces.MesasDisponiblesInterface;
import Servicios.Fachada;
import Utilitarios.Observable;
import Utilitarios.Observador;
import java.util.List;

/**
 *
 * @author lucas
 */
public class MesasDisponiblesControlador implements Observador {

    private Jugador jugador;
    private MesasDisponiblesInterface vista;
    
    
    public MesasDisponiblesControlador(Jugador jugador, MesasDisponiblesInterface vista) {
        this.jugador = jugador;
        this.vista = vista;
        this.hidratarLista();
        Fachada.getInstancia().suscribir(this);
        
    }
    
     public void unirseMesa(Mesa mesa) {
         JugadorMesa jm = this.jugador.unirseAMesa(mesa);
         Fachada.getInstancia().agregarJugadorMesaAMesa(jm, mesa);
         this.vista.siguienteVentana(jm);
     }
     
    
    
    private void hidratarLista() {
        List<Mesa> mesas = Fachada.getInstancia().obtenerMesasDisponibles();
        this.vista.hidratarLista(mesas);
    }
    
    @Override
    public void actualizar(Observable origen, Evento evento) {
         if (evento.equals(Observador.Evento.LISTADO_MESAS_MODIFICADO)) {
            hidratarLista();
         }
        
         
         
    }

    

   
    
}
