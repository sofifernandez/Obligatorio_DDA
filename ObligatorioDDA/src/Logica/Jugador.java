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
    private List<Mesa> mesas;
    private List<Apuesta> apuetas;

    public Jugador(String cedula, String password) {
        super(cedula, password);
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public List<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(List<Mesa> mesas) {
        this.mesas = mesas;
    }

    public List<Apuesta> getApuetas() {
        return apuetas;
    }

    public void setApuetas(List<Apuesta> apuetas) {
        this.apuetas = apuetas;
    }
    
}
