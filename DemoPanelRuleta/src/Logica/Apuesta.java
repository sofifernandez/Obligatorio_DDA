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
public class Apuesta {
    private Casillero casillero;
    private Ronda ronda;
    private JugadorMesa jugadorMesa;
    private List<Ficha> fichas;

    public Apuesta(Casillero casillero, Ronda ronda, JugadorMesa jugadorMesa, List<Ficha> fichas) {
        this.casillero = casillero;
        this.ronda = ronda;
        this.jugadorMesa = jugadorMesa;
        this.fichas = fichas;
    }

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
    
    public int pagarGanador(int numeroSorteado){
        int totalApostado = this.totalApostado();
        int totalAPagar=0;
        if(this.casillero.contieneValor(numeroSorteado)){ //Los que ganaron en la apuesta
            int factorPago = this.casillero.getTipo().getFactorDePago();
            this.jugadorMesa.actualizarSaldo(totalApostado*factorPago);
            totalAPagar=totalApostado*factorPago;
        }
        return totalAPagar;
    }
    
    public void agregarFicha(Ficha ficha) throws ApuestaInvalidaException{
        if(ficha.getValor()<jugadorMesa.getJugador().getSaldo()){
            fichas.add(ficha);
            this.jugadorMesa.actualizarSaldo(-1*ficha.getValor());
            //this.getRonda().apuestaActualizada();
        } else {
            throw new ApuestaInvalidaException("No tienes saldo suficiente");
        }
    }
    
    public int ultimaFichaApostada(){
        int ultimaPosicion= this.getFichas().size()-1;
        return this.getFichas().get(ultimaPosicion).getValor();
    }

    @Override
    public String toString() {
        return "Apuesta{" + "casillero=" + casillero + ", jugadorMesa=" + jugadorMesa + '}';
    }
    
    public boolean esDocenaDeJugador(){
        return this.casillero.getCodUniversal()>=40 && this.casillero.getCodUniversal()<=42;
    }
   
    
    
}
