/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion.Controladores;

import Excepciones.ApuestaInvalidaException;
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
        this.setCasilleros();
        this.setBotonesCasilleros();
        this.setTiposHabilitados();
        this.actualizarDatosMesa();
        this.setNombreJugador();
        jm.getJugador().suscribir(this);
        jm.getMesa().suscribir(this);
    }

    private void setCasilleros() {
        for (int i = 0; i < 51; i++) {
            this.vista.setCasilleros(i);
        }
    }

    private void setBotonesCasilleros() {
        this.vista.setBotonesCasilleros();
    }

    private void actualizarDatosMesa() {
        this.vista.actualizarSaldo(jm.getJugador().getSaldo());
        this.vista.actualizarNumRonda(jm.getMesa().getIdRonda());
        this.vista.actualizarNumMesa(jm.getMesa().getIdMesa());
        this.actualizarNumSorteado();
    }

    private void actualizarNumSorteado() {
        int numSorteado = jm.getMesa().rondaActual().getNumeroSorteado();
        if (numSorteado >= 0) {
            this.vista.actualizarNumSorteado(jm.getMesa().rondaActual().getNumeroSorteado() + "");
        } else {
            this.vista.actualizarNumSorteado("-");
        }
    }

    private void setNombreJugador() {
        this.vista.setNombreJugador(jm.getJugador().getNombreCompleto());
    }

    private void bloquearMesa() {
        this.vista.bloquearMesa();
    }

    private void setTiposHabilitados() {
        List<TipoApuesta> todosTipos = Fachada.getInstancia().getTipos();
        List<TipoApuesta> tiposHabilitados = jm.getMesa().getTiposApuestas();
        List<Integer> casilleros = new ArrayList();
        for (TipoApuesta tip : todosTipos) {
            if (tiposHabilitados.contains(tip)) {
                casilleros.addAll(tip.getCellCodes());
            }
        }
        this.vista.setTiposHabilitados(casilleros);
    }

    public void setApuesta(int cellCode, int valorFicha) {
        try {
            this.jm.realizarApuesta(cellCode, valorFicha);
        } catch (ApuestaInvalidaException e) {
            this.vista.mostrarMensaje(e.getMessage());
        }
    }

    public void abandonarMesa() {
        if (this.vista.mensajeConfirmacion("Está seguro de que desea salir?") == 0) {
            jm.getMesa().borrarJugadorMesa(jm);
            jm.getJugador().desuscribir(this);
            jm.getMesa().desuscribir(this);
            this.vista.cerrar();
        }

    }

    @Override
    public void actualizar(Observable origen, Evento evento) {
        if (evento.equals(Observador.Evento.SORTEO_REALIZADO)) {
            actualizarDatosMesa();
            bloquearMesa();
            this.vista.limpiarMesa();
        }
        if (evento.equals(Observador.Evento.DATOS_MESA_ACTUALIZADOS)) {
            actualizarDatosMesa();
            this.vista.desbloquearMesa();
        }

        if (evento.equals(Observador.Evento.MESA_CERRADA)) {
            this.vista.mostrarMensaje("El croupier ha cerrado la mesa");
            this.vista.cerrar();
        }
    }

}
