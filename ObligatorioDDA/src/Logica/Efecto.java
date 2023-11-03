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
public abstract class Efecto {

    private String nombre;
    private List<Ronda> rondas;

    public Efecto(String nombre) {
        this.nombre = nombre;
        rondas= new ArrayList();
    }
    
    
    
    public abstract int sortear();
    
    public List<Ronda> getRondas() {
        return rondas;
    }

    public void setRondas(List<Ronda> rondas) {
        this.rondas = rondas;
    }
    
    public void agregarRonda(Ronda ronda){
        rondas.add(ronda);
    }
    
   
}
