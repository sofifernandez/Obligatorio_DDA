/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sofia
 */
public class JugadorMesa {
    
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
    
    public void actualizarSaldo(int x){
        this.jugador.actualizarSaldo(x);
    }
    
    public void realizarApuesta(Casillero casillero, Ficha ficha, Ronda ronda){
        
        for(Apuesta a: this.apuestas){
            if(a.getCasillero().equals(casillero) && a.getRonda().equals(ronda)){
                a.agregarFicha(ficha);
                return;
            }
        }
        this.nuevaApuesta(casillero, ficha, ronda);
     
    }

    private void nuevaApuesta(Casillero casillero, Ficha ficha, Ronda ronda) {
        List<Ficha> fichas = new ArrayList();
        fichas.add(ficha);
        Apuesta nuevaApuesta = new Apuesta(casillero, ronda, this, fichas);
        nuevaApuesta.getRonda().agregarApuesta(nuevaApuesta);
        this.apuestas.add(nuevaApuesta);
    }

    @Override
    public String toString() {
        return "JugadorMesa{" + "jugador=" + jugador.getSaldo() + '}';
    }
    
    
    
    
}
