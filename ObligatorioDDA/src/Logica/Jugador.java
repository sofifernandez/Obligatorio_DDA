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
public class Jugador extends Usuario {
    private int saldo;
    private List<JugadorMesa> jugadorMesas;

    public Jugador(String cedula, String password) {
        super(cedula, password);
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    public void unirseAMesa(Mesa mesa){
        if(saldo>0){
            JugadorMesa nuevoJuego= new JugadorMesa(this, mesa);
            jugadorMesas.add(nuevoJuego);
        }
        
    }
    
    public void actualizarSaldo(int x){
        setSaldo(this.saldo+x);
    }
    
}
