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

    
    
//    public void setEfecto(Efecto efecto) {
//        this.efecto = efecto;
//    }
    
    public void sortear(){
        this.getEfecto().agregarRonda(this);
        this.setNumeroSorteado(this.getEfecto().sortear());
        //return this.getEfecto().sortear();
    }
    
    public void sortearDos(){
        
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

    @Override
    public String toString() {
        return "Ronda{" + "apuestas=" + apuestas + ", efecto=" + efecto + ", numeroSorteado=" + numeroSorteado + ", numeroRonda=" + numeroRonda + '}';
    }
    
    public List<Integer> casillerosApostados(){
        List<Integer> casilleros=new ArrayList();
        for(Apuesta a: this.apuestas){
            casilleros.add(a.getCasillero().getCodUniversal());
        }
        return casilleros;
    }
    
    
}
