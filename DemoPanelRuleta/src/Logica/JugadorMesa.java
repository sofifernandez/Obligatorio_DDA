/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Excepciones.ApuestaInvalidaException;
import Utilitarios.Observable;
import Utilitarios.Observador;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author sofia
 */
public class JugadorMesa extends Observable {

    private Jugador jugador;
    private Mesa mesa;
    private List<Apuesta> apuestas = new ArrayList();

    public JugadorMesa(Jugador jugador, Mesa mesa) {
        this.jugador = jugador;
        this.mesa = mesa;
        this.apuestas = new ArrayList();
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public List<Apuesta> getApuestas() {
        return apuestas;
    }

    public void setApuestas(List<Apuesta> apuestas) {
        this.apuestas = apuestas;
    }

    public void actualizarSaldo(int x) {
        this.jugador.actualizarSaldo(x);
    }

    public void realizarApuesta(int cellCode, int valorFicha) throws ApuestaInvalidaException {
        Casillero casillero = this.getMesa().obtenerCasillero(cellCode);
        if (casillero == null) {
            throw new ApuestaInvalidaException("Apuesta no habilitada");
        }
        Ficha ficha = new Ficha(valorFicha);
        Ronda ronda = this.getMesa().rondaActual();
        for (Apuesta a : this.apuestas) {
            if (a.getCasillero().equals(casillero) && a.getRonda().equals(ronda)) {
                a.agregarFicha(ficha);
                ronda.apuestaActualizada();
                return;
            }
        }
        this.nuevaApuesta(casillero, ficha, ronda);

    }

    private void nuevaApuesta(Casillero casillero, Ficha ficha, Ronda ronda) throws ApuestaInvalidaException {

        try {
            List<Ficha> fichas = new ArrayList();
            Apuesta nuevaApuesta = new Apuesta(casillero, ronda, this, fichas);
            casillero.validarApuesta(ronda, nuevaApuesta);
            nuevaApuesta.agregarFicha(ficha);
            nuevaApuesta.getRonda().agregarApuesta(nuevaApuesta);
            this.apuestas.add(nuevaApuesta);
            ronda.apuestaActualizada();

        } catch (ApuestaInvalidaException ex) {
            throw new ApuestaInvalidaException(ex.getMessage());
        }

//        if (chequearRestriccionDocenas(ronda)) {
//            throw new ApuestaInvalidaException("No se puede apostar a mas de una docena por ronda");
//        }
//        if(chequearRestriccionColores(nuevaApuesta)){
//            throw new ApuestaInvalidaException("Apuesta inválida. Martingala picarón");
//        }
    }

    private boolean chequearRestriccionColores(Apuesta apuesta) {
        Ronda rondaActual = apuesta.getRonda();
        int idRondaAnterior = rondaActual.getNumeroRonda() - 1;
        Ronda rondaAnterior = this.getMesa().obtenerRondaConID(idRondaAnterior);
        if (noSeAplicaRestriccion(rondaAnterior)) {
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
        for (Apuesta a : apuestas) {
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
        for (Apuesta a : apuestas) {
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

    private boolean noSeAplicaRestriccion(Ronda ronda) {
        boolean salioCeroAnterior = ronda.getNumeroSorteado() == 0;
        boolean seApostoRojo = false;
        boolean seApostoNegro = false;
        if (salioCeroAnterior) {
            for (Apuesta a : this.getApuestas()) {
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

    private boolean chequearRestriccionDocenas(Ronda ronda) { //Restricciones: no se puede apostar a más de una docena por ronda.
        for (Apuesta a : this.apuestas) {
            if (a.esDocena() && a.getRonda().equals(ronda)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "JugadorMesa{" + "jugador=" + jugador.getSaldo() + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.jugador);
        hash = 67 * hash + Objects.hashCode(this.mesa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JugadorMesa other = (JugadorMesa) obj;
        if (!Objects.equals(this.jugador, other.jugador)) {
            return false;
        }
        return Objects.equals(this.mesa, other.mesa);
    }

}
