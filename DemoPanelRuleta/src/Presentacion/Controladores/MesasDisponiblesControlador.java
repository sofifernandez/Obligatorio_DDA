/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion.Controladores;

import Excepciones.MesaInvalidaException;
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
         try{JugadorMesa jm = this.jugador.unirseAMesa(mesa);
         Fachada.getInstancia().agregarJugadorMesaAMesa(jm, mesa);
         this.vista.siguienteVentana(jm);
         
         }
         catch (MesaInvalidaException e){
             this.vista.mostrarError(e.getMessage());
         }
        
         
     }
     
    public void logout() {
        if(this.vista.mensajeConfirmacion("Estás seguro que desea salir?") == 0) {
            Fachada.getInstancia().logout(jugador);
            Fachada.getInstancia().desuscribir(this);
            this.vista.cerrar();
        }
    }
    
    public void logoutDirecto(){
        Fachada.getInstancia().logout(jugador);
        Fachada.getInstancia().desuscribir(this);
        this.vista.cerrar();
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
