/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        Apuesta nuevaApuesta = new Apuesta(casillero, ronda, this, fichas);
        if(chequearRestriccionDocenas()){
            System.out.println("no se puede apostar a mas de una docena por ronda.");
            return; //acá excepciones!
        }
        System.out.println("sigue");
        nuevaApuesta.agregarFicha(ficha);
        nuevaApuesta.getRonda().agregarApuesta(nuevaApuesta);
        this.apuestas.add(nuevaApuesta);
    }
    
//    private boolean chequearRestriccionColores(Ronda ronda){
//        for (Apuesta a: ronda.getApuestas()){
//            if (a.esDocenaDeJugador(this)){
//                return true; 
//            }
//        }
//        return false;
//    }
    
    
    private boolean chequearRestriccionDocenas(){ //Restricciones: no se puede apostar a más de una docena por ronda.
        for (Apuesta a: this.apuestas){
            if (a.esDocenaDeJugador()){
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
