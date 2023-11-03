/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.List;

/**
 *
 * @author lucas
 */
public class Apuesta {
    private Casillero casillero;
    private Ronda ronda;
    private JugadorMesa jugadorMesa;
    private List<Ficha> fichas;

    public Casillero getCasillero() {
        return casillero;
    }

    public void setCasillero(Casillero casillero) {
        this.casillero = casillero;
    }

    public Ronda getRonda() {
        return ronda;
    }

    public void setRonda(Ronda ronda) {
        this.ronda = ronda;
    }

    public JugadorMesa getJugadorMesa() {
        return jugadorMesa;
    }

    public void setJugadorMesa(JugadorMesa jugadorMesa) {
        this.jugadorMesa = jugadorMesa;
    }

    public List<Ficha> getFichas() {
        return fichas;
    }

    public void setFichas(List<Ficha> fichas) {
        this.fichas = fichas;
    }
    
    public boolean IsApuestasDirecta(){
        return this.getCasillero().esDirecto();
    }
    
}
