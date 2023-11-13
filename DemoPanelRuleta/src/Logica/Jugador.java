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
    
    public JugadorMesa unirseAMesa(Mesa mesa){
        JugadorMesa nuevoJuego= new JugadorMesa(this, mesa);
        if(saldo>0){
            jugadorMesas.add(nuevoJuego);
            return nuevoJuego;
        }
        return null;
    }
  
    public void actualizarSaldo(int x){
        this.setSaldo(this.saldo + x);
    }
    
}
