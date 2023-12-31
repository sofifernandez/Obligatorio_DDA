/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Utilitarios.Observable;
import Utilitarios.Observador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class Mesa extends Observable {
    
    private Crupier crupier; //ES NECESARIO QUE CONOZCA AL CRUPIER?
    private List<JugadorMesa> jugadoresMesa; //es necesario que conozca esto?
    private List<TipoApuesta> tiposApuestas; 
    private List<Ronda> rondas;
    private int balance;

    
    private int idRonda;
    private int idMesa;
    private boolean disponible;
    private static int idClase = 0;

    public Mesa(TipoApuestaDirecta directa) {
       this.balance=0;
       this.idMesa = idClase + 1;
       this.disponible = false;
       this.tiposApuestas=new ArrayList();
       this.tiposApuestas.add(directa);
       this.rondas=new ArrayList();
       this.jugadoresMesa=new ArrayList();
       this.idRonda=0;
       idClase++;
    }

    public List<Ronda> getRondas() {
        return rondas;
    }

    public void setRondas(List<Ronda> rondas) {
        this.rondas = rondas;
    }

    public List<JugadorMesa> getJugadoresMesa() {
        return jugadoresMesa;
    }

    public void setJugadoresMesa(List<JugadorMesa> jugadoresMesa) {
        this.jugadoresMesa = jugadoresMesa;
    }

    
    public int getBalance() {
        return balance;
    }
    public int getIdMesa() {
        return idMesa;
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
        this.nuevaRonda();
    }
    
    public void nuevaRonda(){
        this.setIdRonda(idRonda+1);
        Ronda ronda=new Ronda(this.idRonda, this);
        this.rondas.add(ronda);
    }
    
    public void lanzar(Efecto efecto){  
        Ronda ronda = this.rondaActual();
        ronda.setEfecto(efecto);
        ronda.sortear();
        this.notificar(Observador.Evento.SORTEO_REALIZADO);
    }
    
    public Ronda obtenerRondaConID(int ID){
        for(Ronda r:rondas){
            if(r.getNumeroRonda()==ID){
                return r;
            }
        }
        return null;
    }
    
    
    public void liquidarRonda(){
        Ronda ultimaRonda= this.rondaActual();
        int balanceRonda= ultimaRonda.liquidar();
        this.actualizarBalance(balanceRonda);
        this.nuevaRonda();
        this.notificar(Observador.Evento.DATOS_MESA_ACTUALIZADOS);
    }
    
    public List<Integer> ultimosResultados(int x){
        List<Ronda> ultimasRondas;
        List<Integer>ultimosResultados = new ArrayList();
        if(this.rondas.size() < x){
            ultimasRondas = this.rondas;
        } else {
            ultimasRondas =  this.rondas.subList(this.getRondas().size() - x, this.rondas.size());
        }
        for (Ronda r: ultimasRondas){
            ultimosResultados.add(r.getNumeroSorteado());
        }
        return ultimosResultados;
    }
    
    public String ultimosResultadosString(){
        String texto="";
        for (Ronda r: this.getRondas()){
            if(r.getNumeroSorteado()>=0)
            texto= texto + " | " + r.getNumeroSorteado();
        }
        return texto;
    }
    
    public String extraerDatosUltimaRonda(){
        String texto="";
        texto= rondaActual().getNumeroRonda()+ " " +
                getBalance()+" " ;
        return texto;
    }
    

    
    public Ronda rondaActual(){
        for(Ronda r: this.rondas){
            if(r.getNumeroRonda()==this.idRonda){
                return r;
            }
        }
        return null;
    }
    
    private void actualizarBalance(int balanceRonda){
        setBalance(getBalance()+balanceRonda);
    }
    
    public void agregarJugadorMesa(JugadorMesa jugador){
        this.jugadoresMesa.add(jugador);
        this.notificar(Observador.Evento.LISTADO_JUGADORES_MODIFICADO);
    }
    
        public void borrarJugadorMesa(JugadorMesa jugador){
        this.jugadoresMesa.remove(jugador);
        this.notificar(Observador.Evento.LISTADO_JUGADORES_MODIFICADO);
    }

    public boolean esDisponible() {
        return this.disponible;
    }

    public void setDisponible(boolean b) {
        this.disponible = b;
        //this.notificar(Observador.Evento.LISTADO_MESAS_MODIFICADO);
    }
    
    public List<Jugador> obtenerJugadores(){
        List<Jugador> jugadores= new ArrayList();
        for(JugadorMesa jm: jugadoresMesa){
            jugadores.add(jm.getJugador());
        }
        return jugadores;
    }
    
    public void borrarTodosLosJugadores(){
        jugadoresMesa.clear();
        this.notificar(Observador.Evento.MESA_CERRADA);
    }

    @Override
    public String toString() {
        return "Mesa{" + "idMesa=" + idMesa + '}';
    }
    
    public Casillero obtenerCasillero(int cellCode){
        for(TipoApuesta t: tiposApuestas){
            Casillero casillero=t.obtenerCasillero(cellCode);
            if(casillero!=null){
                return casillero;
            }
        }
        return null;
    }
    
    public List<Apuesta> getApuestasRondaActual(){
        Ronda rondaActual= rondaActual();
        return rondaActual.getApuestas();
    }
    
    public void apuestaActualizada(){
        this.notificar(Observador.Evento.APUESTA_ACTUALIZADA);
    }
    
}
