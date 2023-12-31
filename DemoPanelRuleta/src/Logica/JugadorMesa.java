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
            nuevaApuesta.agregarFicha(ficha);
            casillero.validarApuesta(nuevaApuesta);
            nuevaApuesta.getRonda().agregarApuesta(nuevaApuesta);
            this.apuestas.add(nuevaApuesta);
            ronda.apuestaActualizada();

        } catch (ApuestaInvalidaException ex) {
            throw new ApuestaInvalidaException(ex.getMessage());
        }

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
