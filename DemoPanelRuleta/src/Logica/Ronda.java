/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author lucas
 */
public class Ronda {
    private List<Apuesta> apuestas;
    private Efecto efecto;
    private int numeroSorteado;
    private int numeroRonda;
    private Mesa mesa;
    
    public Ronda(int numeroRonda, Mesa mesa) {
        this.numeroRonda=numeroRonda;
        this.mesa=mesa;
        this.apuestas=new ArrayList();
        numeroSorteado=-1;
    }

    
    public void setEfecto(Efecto efecto) {
        this.efecto = efecto;
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
    
    public int liquidar(){
        int ganancias=0;
        int perdidas=0;
        for(Apuesta a: apuestas){
            ganancias+=a.totalApostado();
            perdidas+=a.pagarGanador(this.getNumeroSorteado());
        }
        return ganancias-perdidas;
    }
    
    public int totalApostado(){
        int total=0;
        for(Apuesta a: apuestas){
            total+=a.totalApostado();
        }
        return total;
    }
    
    public int totalPago(){
        int perdidas=0;
        for(Apuesta a: apuestas){
            perdidas+=a.perdidas(this.getNumeroSorteado());
        }
        return perdidas;
    }
    
    public int balanceFinal(){
        int recoleccion=this.montoTotalApuestas();
        int liquidacion=this.totalPago();
        return recoleccion-liquidacion;
    }
    
    public void apuestaActualizada(){
        this.getMesa().apuestaActualizada();
    }
    
    public int montoTotalApuestas(){
        int total=0;
        for(Apuesta a: apuestas){
            total+=a.totalApostado();
        }
        return total;
    }
    
    
     @Override
    public String toString() {
        return "Ronda{" + "apuestas=" + apuestas + ", numeroSorteado=" + numeroSorteado + ", numeroRonda=" + numeroRonda + '}';
    }

    

    public void agregarApuesta(Apuesta apuesta) {
        this.apuestas.add(apuesta);
    }

    public int totalApuestasEnCasillero(int i) {
        int total=0;
        for (Apuesta a: apuestas){
            if(a.getCasillero().getCodUniversal()==i){
                total+=a.totalApostado();
            }
        }
        return total;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ronda other = (Ronda) obj;
        if (this.numeroRonda != other.numeroRonda) {
            return false;
        }
        return Objects.equals(this.mesa, other.mesa);
    }

    
    
    
    
    
    
    
}
