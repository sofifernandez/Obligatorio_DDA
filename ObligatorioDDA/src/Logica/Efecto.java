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
    //private List<Ronda> rondas;
    //private Ronda ronda;

    public Efecto(String nombre) {
        this.nombre = nombre;
        //rondas= new ArrayList();
    }
    
    public abstract int sortear(Ronda ronda);
    
//    public Ronda getRonda() {
//        return ronda;
//    }
//
//    public void setRonda(Ronda ronda) {
//        this.ronda = ronda;
//    }
    
//    public void agregarRonda(Ronda ronda){
//        rondas.add(ronda);
//    }
    
   
}
