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
public class Ronda {
    private List<Apuesta> apuestas;
    private Efecto efecto;
    private int numeroSorteado;
    private int numeroRonda;
    //agrego la mesa
    private Mesa mesa;

    public Ronda(int numeroRonda, Efecto efecto, Mesa mesa) {
        this.numeroRonda=numeroRonda;
        this.efecto=efecto;
        this.mesa=mesa;
        //this.numeroSorteado=this.sortear();
    }

    public List<Apuesta> getApuestas() {
        return apuestas;
    }

    public int getNumeroSorteado() {
        return numeroSorteado;
    }

    public void setNumeroSorteado(int numeroSorteado) {
        this.numeroSorteado = numeroSorteado;
    }

    public int getNumeroRonda() {
        return numeroRonda;
    }

    public void setNumeroRonda(int numeroRonda) {
        this.numeroRonda = numeroRonda;
    }

    public void setApuestas(List<Apuesta> apuestas) {
        this.apuestas = apuestas;
    }

    public Efecto getEfecto() {
        return efecto;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
    
    public void sortear(){
        this.setNumeroSorteado(this.efecto.sortear(this));
    }
    
    public List<Integer> ultimosResultados(int x){
        return this.mesa.ultimosResultados(x);
    }
    
    public List<Integer> numerosApostadosDirectos(){
        List<Integer> numeros=new ArrayList();
        for(Apuesta a: this.getApuestas()){
            if(a.IsApuestasDirecta()){
                numeros.add(a.getCasillero().getCodUniversal());
            }
        }
        return numeros;
    }

    
    public List<Integer> numerosApostados(){
        List<Integer> casilleros=new ArrayList();
        for(Apuesta a: this.apuestas){
            casilleros.add(a.getCasillero().getCodUniversal());
        }
        return casilleros;
    }
    
    public void liquidar(){
        for(Apuesta a: apuestas){
            a.actualizarSaldo(this.getNumeroSorteado());
        }
    }
    
     @Override
    public String toString() {
        return "Ronda{" + "apuestas=" + apuestas + ", efecto=" + efecto + ", numeroSorteado=" + numeroSorteado + ", numeroRonda=" + numeroRonda + '}';
    }
    
    
}
