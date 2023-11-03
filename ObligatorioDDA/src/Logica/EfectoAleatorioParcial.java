/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author lucas
 */
public class EfectoAleatorioParcial extends Efecto{

    public EfectoAleatorioParcial(String nombre) {
        super(nombre);
    }

    @Override
    public int sortear(Ronda ronda) {
        List<Integer> ultimosTresNumeros = ronda.ultimosResultados(3);
        System.out.println(ultimosTresNumeros);
        Random nRandom = new Random();
        int numero = nRandom.nextInt(37);
        int numeroAleatorio;
        
        do {
            numeroAleatorio = nRandom.nextInt(37);
        } while (ultimosTresNumeros.contains(numeroAleatorio));
        
        return numero;
        
    }

            
   
    
}
