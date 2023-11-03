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
    
    public int totalApostado(){
        int total=0;
        for(Ficha f: fichas){
            total+= f.getValor();
        }
        return total;
    }
    
    public void actualizarSaldo(int x){
        int totalApostado=this.totalApostado();
        if(this.casillero.contieneValor(x)){
            int factorPago= this.casillero.getTipo().getFactorDePago();
            this.jugadorMesa.actualizarSaldo(totalApostado*factorPago);
        } 
    }
    
    public void agregarFicha(Ficha ficha){
        if(ficha.getValor()<jugadorMesa.getJugador().getSaldo()){
            fichas.add(ficha);
            this.jugadorMesa.actualizarSaldo(-1*ficha.getValor());
        }
    }
    
}
