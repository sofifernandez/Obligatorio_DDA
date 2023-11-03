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
    };
    
    
}
