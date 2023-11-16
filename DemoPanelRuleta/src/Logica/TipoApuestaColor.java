/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Excepciones.ApuestaInvalidaException;
import java.util.List;

/**
 *
 * @author lucas
 */
public class TipoApuestaColor extends TipoApuesta{
    
    public TipoApuestaColor(int factorDePago, String nombre) {
        super(factorDePago, nombre);
    }

    @Override
    public void validarApuesta(Ronda rondaActual, Apuesta apuesta) throws ApuestaInvalidaException {
        JugadorMesa jm= apuesta.getJugadorMesa();
        Ronda ronda= apuesta.getRonda();
        if(chequearRestriccionColores(jm, apuesta)){
            throw new ApuestaInvalidaException("No se puede Martingalear");
        }
    }
    
    
    private boolean chequearRestriccionColores(JugadorMesa jm,Apuesta apuesta) {
        Ronda rondaActual = apuesta.getRonda();
        int idRondaAnterior = rondaActual.getNumeroRonda() - 1;
        Ronda rondaAnterior = jm.getMesa().obtenerRondaConID(idRondaAnterior);
        if (noSeAplicaRestriccion(rondaAnterior, jm)) {
            return false;
        }
        if (apuesta.esNegro()) {
            if (martingalaNegros(rondaAnterior, apuesta)) {
                return true;
            }
        }
        if (apuesta.esRojo()) {
            if (martingalaRojos(rondaAnterior, apuesta)) {
                return true;
            }
        }
        return false;
    }

    private boolean martingalaNegros(Ronda rondaAnterior, Apuesta apuestaActual) {
        for (Apuesta a : apuestaActual.getJugadorMesa().getApuestas()) {
            if (a.getRonda().equals(rondaAnterior) && !a.esApuestaGanadora() && a.esNegro()) {
                int totalAnterior = a.totalApostado();
                int totalActual = apuestaActual.totalApostado();
                if (totalAnterior < totalActual) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean martingalaRojos(Ronda rondaAnterior, Apuesta apuestaActual) {
        for (Apuesta a : apuestaActual.getJugadorMesa().getApuestas()) {
            if (a.getRonda().equals(rondaAnterior) && !a.esApuestaGanadora() && a.esRojo()) {
                int totalAnterior = a.totalApostado();
                int totalActual = apuestaActual.totalApostado();
                if (totalAnterior < totalActual) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean noSeAplicaRestriccion(Ronda ronda, JugadorMesa jm) {
        boolean salioCeroAnterior = ronda.getNumeroSorteado() == 0;
        boolean seApostoRojo = false;
        boolean seApostoNegro = false;
        if (salioCeroAnterior) {
            for (Apuesta a : jm.getApuestas()) {
                if (a.getRonda().equals(ronda) && a.esRojo()) {
                    seApostoRojo = true;
                }
                if (a.getRonda().equals(ronda) && a.esNegro()) {
                    seApostoNegro = true;
                }
            }

        }

        return seApostoRojo && seApostoNegro;
    }
}
