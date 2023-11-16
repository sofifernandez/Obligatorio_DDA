/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Excepciones.MesaInvalidaException;
import Utilitarios.Observador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class Jugador extends Usuario {
    private int saldo;
    private List<JugadorMesa> jugadorMesas;

    public Jugador(String cedula, String password) {
        super(cedula, password);
        this.jugadorMesas = new ArrayList();
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    public JugadorMesa unirseAMesa(Mesa mesa) throws MesaInvalidaException{
        if(mesa==null)
            throw new MesaInvalidaException("Selecciona una mesa");
        if(!mesa.esDisponible())
            throw new MesaInvalidaException("La mesa no esta disponible");
        JugadorMesa nuevoJuego= new JugadorMesa(this, mesa);
        if(yaExisteJugadorMesa(nuevoJuego)){
            throw new MesaInvalidaException("Ya participas de esta mesa");
        }
        if(saldo<=0){
            throw new MesaInvalidaException("No tienes saldo suficiente");
        }
        
        jugadorMesas.add(nuevoJuego);
        return nuevoJuego;
    }
    
    private boolean yaExisteJugadorMesa(JugadorMesa jm){
        List<JugadorMesa> jugadoresDeLaMesa= jm.getMesa().getJugadoresMesa();
        for(JugadorMesa j: jugadoresDeLaMesa){
            if(j.equals(jm))
                return true;
        }
        return false;
    }
  
    public void actualizarSaldo(int x){
        this.setSaldo(this.saldo + x);
        this.notificar(Observador.Evento.DATOS_MESA_ACTUALIZADOS);
    }
    
}
