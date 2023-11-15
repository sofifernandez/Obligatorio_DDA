/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion.Controladores;

import Logica.Apuesta;
import Logica.Crupier;
import Logica.TipoApuesta;
import Presentacion.Interfaces.MesaCrupierInterface;
import Servicios.Fachada;
import Utilitarios.Observable;
import Utilitarios.Observador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sofia
 */
public class MesaCrupierControlador implements Observador {
    private Crupier crupier;
    private MesaCrupierInterface vista;

    public MesaCrupierControlador(Crupier crupier, MesaCrupierInterface vista) {
        this.crupier = crupier;
        this.vista = vista;
        this.setCasilleros();
        
        this.setTiposHabilitados();
        this.actualizarDatosMesa();
        crupier.getMesa().suscribir(this);
        
    }
    
    private void setCasilleros(){
        for(int i=0; i<51;i++){
            this.vista.setCasilleros(i);
        }
    }
    
    private void actualizarDatosMesa(){
      this.vista.actualizarNumRonda(crupier.getMesa().getIdRonda());
      this.vista.actualizarNumMesa(crupier.getMesa().getIdMesa());
      this.vista.actualizarNumSorteado(crupier.getMesa().rondaActual().getNumeroSorteado());
    }
    
    private void setTiposHabilitados(){
        List<TipoApuesta> todosTipos= Fachada.getInstancia().getTipos();
        List<TipoApuesta> tiposHabilitados=crupier.getMesa().getTiposApuestas();
        List<Integer> casilleros= new ArrayList();
        for(TipoApuesta tip:todosTipos){
            if(tiposHabilitados.contains(tip)){
                casilleros.addAll(tip.getCellCodes());
            }
        }
        this.vista.setTiposHabilitados(casilleros);
    }
    
    public void actualizarApuesta(){
        List<Apuesta> apuestas= crupier.getMesa().rondaActual().getApuestas();
        for(Apuesta a: apuestas){
            this.vista.setApuesta(a.getCasillero().getCodUniversal(),a.ultimaFichaApostada());
        }
    }

    @Override
    public void actualizar(Observable origen, Evento evento) {
        if (evento.equals(Observador.Evento.APUESTA_ACTUALIZADA)) {
            actualizarApuesta();
        } 
        
    }
    
    
    
}
