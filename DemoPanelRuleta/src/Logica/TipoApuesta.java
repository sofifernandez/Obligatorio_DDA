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
public abstract class TipoApuesta {
    private int factorDePago;
    private String nombre;
    private List<Casillero> casilleros;

    public TipoApuesta(int factorDePago, String nombre) {
        this.factorDePago = factorDePago;
        this.nombre = nombre;
    }
    
    //public abstract void configurarCasilleros(List<Casillero> casilleros);
    
    public void configurarCasilleros(List<Casillero> casilleros) {
        List<Casillero> nueva=new ArrayList();
        for(Casillero c: casilleros){
            if(c.getTipo().equals(this)){
                nueva.add(c);
            }
        }
        this.setCasilleros(nueva);
    }

    public int getFactorDePago() {
        return factorDePago;
    }

    public void setFactorDePago(int factorDePago) {
        this.factorDePago = factorDePago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Casillero> getCasilleros() {
        return casilleros;
    }

    public void setCasilleros(List<Casillero> casilleros) {
        this.casilleros = casilleros;
    }
    
    public List<Integer> getCellCodes(){
        List<Integer> numerosCeldas=new ArrayList();
        for(Casillero c: casilleros){
            numerosCeldas.add(c.getCodUniversal());
        }
        return numerosCeldas;
    }
    
    public Casillero obtenerCasillero(int cellCode){
        Casillero casillero=null;
        for(Casillero c: casilleros){
            if(c.getCodUniversal()==cellCode){
                casillero=c;
            }
        }
        return casillero;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.nombre);
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
        final TipoApuesta other = (TipoApuesta) obj;
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public String toString() {
        //for(Casillero c:)
        return "TipoApuesta{" + "casilleros=" + casilleros + '}';
    }
    
    
    
    
    
}
