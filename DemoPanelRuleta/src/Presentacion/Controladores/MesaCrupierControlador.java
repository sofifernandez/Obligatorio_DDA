/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion.Controladores;

import Logica.Apuesta;
import Logica.Crupier;
import Logica.Efecto;
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
    }

    private void setCasilleros() {
        for (int i = 0; i < 51; i++) {
            this.vista.setCasilleros(i);
        }
    }

    private void actualizarDatosMesa() {
        this.vista.actualizarNumRonda(crupier.getMesa().getIdRonda());
        this.vista.actualizarNumMesa(crupier.getMesa().getIdMesa());
        this.vista.actualizarNumSorteado(crupier.getMesa().rondaActual().getNumeroSorteado());
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

    public void actualizarApuestas() {
        Ronda ronda = crupier.getMesa().rondaActual();
        for (int i = 0; i < 51; i++) {
            int totalApostado = ronda.totalApuestasEnCasillero(i);
            if (totalApostado > 0) {
                this.vista.setApuesta(i, totalApostado);
            }
        }
    }

    public void lanzarPagar(Efecto efecto) {
        if (!seLanzo) {
            crupier.lanzar(efecto);
            this.vista.actualizarTextoBoton("Pagar");
        } else {
            crupier.liquidarPagos();
            this.vista.actualizarTextoBoton("Lanzar");
        }
        seLanzo = !seLanzo;
    }

    private void hidratarListaEfectos() {
        List<Efecto> efectos = Fachada.getInstancia().getEfectos();
        this.vista.hidratarListaEfectos(efectos);
    }

    @Override
    public void actualizar(Observable origen, Evento evento) {
        if (evento.equals(Observador.Evento.APUESTA_ACTUALIZADA)) {
            actualizarApuestas();
        }
        if (evento.equals(Observador.Evento.SORTEO_REALIZADO)) {
            this.vista.bloquearMesa();
            this.vista.actualizarNumSorteado(crupier.getMesa().rondaActual().getNumeroSorteado());
        }
        
        if (evento.equals(Observador.Evento.DATOS_MESA_ACTUALIZADOS)) {
           actualizarDatosMesa();
           this.vista.limpiarMesa();
           this.vista.desbloquearMesa();
        }
        
    }

}
