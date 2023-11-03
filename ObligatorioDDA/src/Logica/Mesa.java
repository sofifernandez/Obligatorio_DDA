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
    private List<JugadorMesa> jugadoresMesa;
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

    public int getIdRonda() {
        return idRonda;
    }

    public void setIdRonda(int idRonda) {
        this.idRonda = idRonda;
    }

    
    
    
    public Crupier getCrupier() {
        return crupier;
    }

    public void setCrupier(Crupier crupier) {
        this.crupier = crupier;
    }

    public List<JugadorMesa> getJugadores() {
        return jugadoresMesa;
    }

    public void setJugadores(List<JugadorMesa> jugadores) {
        this.jugadoresMesa = jugadores;
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
        this.setIdRonda(idRonda+1);
        //this.idRonda++;
        Ronda ronda=new Ronda(this.idRonda, efecto, this);
        ronda.sortear();
        this.rondas.add(ronda);
    }
    
    public List<Integer> ultimosResultados(int x){
        List<Ronda> ultimasRondas=new ArrayList();
        List<Integer>ultimosResultados=new ArrayList();
        if(this.rondas.size()<x){
            ultimasRondas=this.rondas;
        } else {
            ultimasRondas=  this.rondas.subList(this.getRondas().size() - x, this.rondas.size());
        }
        for (Ronda r: ultimasRondas){
            ultimosResultados.add(r.getNumeroSorteado());
        }
        return ultimosResultados;
    }
    

    
    public Ronda ultimaRonda(){
        for(Ronda r: this.rondas){
            if(r.getNumeroRonda()==this.idRonda){
                return r;
            }
        }
        return null;
    }
    
}
