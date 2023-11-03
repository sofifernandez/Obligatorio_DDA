/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class Mesa {
    
    private Crupier crupier; //ES NECESARIO QUE CONOZCA AL CRUPIER?
    private List<Jugador> jugadores;
    private List<TipoApuesta> tiposApuestas; 
    private List<Ronda> rondas;
    private int balance;
    private int idRonda;

    public Mesa(TipoApuestaDirecta directa) {
       this.balance=0;
       this.tiposApuestas=new ArrayList();
       this.tiposApuestas.add(directa);
       this.rondas=new ArrayList();
       this.idRonda=0;
    }

    public List<Ronda> getRondas() {
        return rondas;
    }

    public void setRondas(List<Ronda> rondas) {
        this.rondas = rondas;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    
    
    
    public Crupier getCrupier() {
        return crupier;
    }

    public void setCrupier(Crupier crupier) {
        this.crupier = crupier;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

   

    public List<TipoApuesta> getTiposApuestas() {
        return tiposApuestas;
    }

    public void setTiposApuestas(List<TipoApuesta> tiposApuestas) {
        this.tiposApuestas = tiposApuestas;
    }
    
    public void agregarTipoApuesta(List<TipoApuesta> tiposNuevos){
        for(TipoApuesta t: tiposNuevos){
            this.tiposApuestas.add(t);
        }
    }
    
    public void nuevaRonda(Efecto efecto){
        this.idRonda++;
        Ronda ronda=new Ronda(this.idRonda, efecto, this);
        ronda.sortear();
        this.rondas.add(ronda);
    }
    
    public List<Integer> ultimosResultados(int x){
        List<Ronda> ultimasRondas=new ArrayList();
        List<Integer>ultimosResultados=new ArrayList();
        ultimasRondas=  this.rondas.subList(this.getRondas().size() - x, this.rondas.size());
        for (Ronda r: ultimasRondas){
            ultimosResultados.add(r.getNumeroSorteado());
        }
        return ultimosResultados;
    }
    
}
