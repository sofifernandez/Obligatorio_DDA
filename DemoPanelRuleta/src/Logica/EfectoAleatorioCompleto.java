/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.Random;

/**
 *
 * @author lucas
 */
public class EfectoAleatorioCompleto extends Efecto{

    public EfectoAleatorioCompleto(String nombre) {
        super(nombre);
    }

    @Override
    public int sortear(Ronda ronda) {
        Random nRandom = new Random();
        return nRandom.nextInt(37);
    }
    
}
