/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion.Controladores;

import Logica.Apuesta;
import Logica.Crupier;
import Logica.Efecto;
import Logica.Jugador;
import Logica.Ronda;
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
    private boolean seLanzo;
    private String datosTabla;

    public MesaCrupierControlador(Crupier crupier, MesaCrupierInterface vista) {
        this.crupier = crupier;
        this.vista = vista;
        this.seLanzo = false;
        this.setCasilleros();
        this.setTiposHabilitados();
        this.actualizarDatosMesa();
        this.vista.actualizarTextoBoton("Lanzar");
        this.hidratarListaEfectos();
        crupier.getMesa().suscribir(this);
        this.vista.bloquearBotonCerrar();
        datosTabla="";
    }

    private void setCasilleros() {
        for (int i = 0; i < 51; i++) {
            this.vista.setCasilleros(i);
        }
    }

    private void actualizarDatosMesa() {
        this.vista.actualizarNumRonda(crupier.getMesa().getIdRonda());
        this.vista.actualizarNumMesa(crupier.getMesa().getIdMesa());
        this.actualizarNumSorteado();
        this.vista.actualizarBalance(crupier.getMesa().getBalance());
        this.vista.actualizarUltimosLanzamientos(crupier.getMesa().ultimosResultadosString());
    }
    
    private void actualizarNumSorteado(){
        int numSorteado = crupier.getMesa().rondaActual().getNumeroSorteado();
        if(numSorteado>=0){
            this.vista.actualizarNumSorteado(crupier.getMesa().rondaActual().getNumeroSorteado()+"");
        } else{
            this.vista.actualizarNumSorteado("-");
        }
    }
   

    public void actualizarApuestas() {
        Ronda ronda = crupier.getMesa().rondaActual();
        for (int i = 0; i < 51; i++) {
            int totalApostado = ronda.totalApuestasEnCasillero(i);
            if (totalApostado > 0) {
                this.vista.setApuesta(i, totalApostado);
            }
        }
            this.vista.actualizarNumApuestas(crupier.getMesa().rondaActual().getApuestas().size());
            this.vista.actualizarMontoApuestas(crupier.getMesa().rondaActual().montoTotalApuestas());
        
    }
    
        private void actualizarJugadores(){
        List<Jugador> jugadores= crupier.getMesa().obtenerJugadores();
        this.vista.actualizarJugadores(jugadores);
    }
    
    private void popularTabla(int idAnterior){
         
//        List<String> textos=new ArrayList();
//        for(int i=1; i<=idAnterior;i++){
//            Ronda r= crupier.getMesa().obtenerRondaConID(i);
//            int balanceAnterior = crupier.getMesa().getBalance() - r.balanceFinal();
//            String idRonda= "Ronda: " + i;
//            String espacio=" ";
//            String balanceAnt="Balance anterior: "+balanceAnterior; 
//            String numAp="Apuestas: "+ r.getApuestas().size();
//            String recoleccion="Recolección: "+ r.totalApostado();
//            String liquidacion= "Liquidacion " +r.totalPago();
//            String balanceAct="Balance posterior: "+r.balanceFinal();
//            String textoCompleto=idRonda+espacio+balanceAnt+espacio+numAp+espacio+recoleccion+espacio+liquidacion+espacio+balanceAct;
//            textos.add(textoCompleto);
//        }
        
            Ronda r= crupier.getMesa().obtenerRondaConID(idAnterior);
            int balanceAnterior = crupier.getMesa().getBalance() - r.balanceFinal();
            String idRonda= "Ronda: " + idAnterior;
            String espacio=" ";
            String balanceAnt="Balance anterior: "+balanceAnterior; 
            String numAp="Apuestas: "+ r.getApuestas().size();
            String recoleccion="Recolección: "+ r.totalApostado();
            String liquidacion= "Liquidacion " +r.totalPago();
            String balanceAct="Balance posterior: "+r.balanceFinal();
            String textoCompleto=idRonda+espacio+balanceAnt+espacio+numAp+espacio+recoleccion+espacio+liquidacion+espacio+balanceAct+ "\n";
            //textos.add(textoCompleto);
            
            datosTabla += textoCompleto;
        
        
            this.vista.popularTabla(datosTabla);
    }
    
    private void setTiposHabilitados() {
        List<TipoApuesta> todosTipos = Fachada.getInstancia().getTipos();
        List<TipoApuesta> tiposHabilitados = crupier.getMesa().getTiposApuestas();
        List<Integer> casilleros = new ArrayList();
        for (TipoApuesta tip : todosTipos) {
            if (tiposHabilitados.contains(tip)) {
                casilleros.addAll(tip.getCellCodes());
            }
        }
        this.vista.setTiposHabilitados(casilleros);
    }

    public void lanzarPagar(Efecto efecto) {
        if (!seLanzo) {
            crupier.lanzar(efecto);
            this.vista.actualizarTextoBoton("Pagar");
            this.vista.desbloquearBotonCerrar();
        } else {
            crupier.liquidarPagos();
            popularTabla(crupier.getMesa().getIdRonda()-1);
            this.vista.actualizarTextoBoton("Lanzar");
            this.vista.bloquearBotonCerrar();
        }
        seLanzo = !seLanzo;
    }

    private void hidratarListaEfectos() {
        List<Efecto> efectos = Fachada.getInstancia().getEfectos();
        this.vista.hidratarListaEfectos(efectos);
    }
    
    public void cerrarMesa(){
        if(this.vista.mensajeConfirmacion("Está seguro de que desea salir?") == 0){
            crupier.liquidarPagos();
            crupier.cerrarMesa();
            crupier.getMesa().desuscribir(this);
            Fachada.getInstancia().logout(crupier);
            this.vista.cerrar();
        }
        
        
    }
    


    @Override
    public void actualizar(Observable origen, Evento evento) {
        if (evento.equals(Observador.Evento.APUESTA_ACTUALIZADA)) {
            actualizarApuestas();
            }
        if (evento.equals(Observador.Evento.SORTEO_REALIZADO)) {
            this.vista.bloquearMesa();
            this.actualizarNumSorteado();
        }
        
        if (evento.equals(Observador.Evento.DATOS_MESA_ACTUALIZADOS)) {
           actualizarDatosMesa();
           this.vista.limpiarMesa();
           this.vista.desbloquearMesa();
           this.actualizarJugadores();
           this.vista.actualizarNumApuestas(0);
           this.vista.actualizarMontoApuestas(0);
        
        }
        
        if (evento.equals(Observador.Evento.LISTADO_JUGADORES_MODIFICADO)) {
           actualizarJugadores();
        }
        
    }

}
