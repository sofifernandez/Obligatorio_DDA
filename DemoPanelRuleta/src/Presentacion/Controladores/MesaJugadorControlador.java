/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion.Controladores;

import Logica.JugadorMesa;
import Logica.TipoApuesta;
import Presentacion.Interfaces.MesaJugadorInterface;
import Servicios.Fachada;
import Utilitarios.Observable;
import Utilitarios.Observador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sofia
 */
public class MesaJugadorControlador implements Observador {
    
    private JugadorMesa jm;
    private MesaJugadorInterface vista;

    public MesaJugadorControlador(JugadorMesa jm, MesaJugadorInterface vista) {
        this.jm = jm;
        this.vista = vista;
        this.prepararMesa();
        this.setTiposHabilitados();
        this.actualizarDatosMesa();
        this.setNombreJugador();
    }
    
    private void prepararMesa(){
        for(int i=0; i<51;i++){
            this.vista.prepararMesa(i);
        }
    }
    
    private void actualizarDatosMesa(){
      this.vista.actualizarSaldo(jm.getJugador().getSaldo());
      this.vista.actualizarNumRonda(jm.getMesa().getIdRonda());
      this.vista.actualizarNumMesa(jm.getMesa().getIdMesa());
      this.vista.actualizarNumSorteado(jm.getMesa().rondaActual().getNumeroSorteado());
    }
    
    private void setNombreJugador(){
        this.vista.setNombreJugador(jm.getJugador().getNombreCompleto());
    }
    
    private void bloquearMesa(){
        this.vista.bloquearMesa();
    }
    
    private void desbloquearMesa(){
        this.vista.desbloquearMesa();
    }
    
    private void setTiposHabilitados(){
        List<TipoApuesta> todosTipos= Fachada.getInstancia().getTipos();
        List<TipoApuesta> tiposHabilitados=jm.getMesa().getTiposApuestas();
        List<Integer> casilleros= new ArrayList();
        for(TipoApuesta tip:todosTipos){
            if(tiposHabilitados.contains(tip)){
                casilleros.addAll(tip.getCellCodes());
            }
        }
        this.vista.setTiposHabilitados(casilleros);
    }
    
//    private void apostar(int cellCode, int valorFicha){
//        try{
//            this.jm.realizarApuesta(cellCode, valorFicha);
//            this.vista.setApuesta();
//        
//        } catch{
//        
//        }
//    }

    @Override
    public void actualizar(Observable origen, Evento evento) {
        if (evento.equals(Observador.Evento.SORTEO_REALIZADO)) {
            bloquearMesa();
        } 
        if (evento.equals(Observador.Evento.DATOS_MESA_ACTUALIZADOS)) {
            actualizarDatosMesa();
            desbloquearMesa();
        } 
    }
    
    
}
