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
    }

    public String getNombre() {
        return nombre;
    }
    
    
    public abstract int sortear(Ronda ronda);

   
}
