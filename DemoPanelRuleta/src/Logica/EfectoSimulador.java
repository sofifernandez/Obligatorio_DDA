/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.List;
import java.util.Random;

/**
 *
 * @author lucas     
 */
public class EfectoSimulador extends Efecto {

    public EfectoSimulador(String nombre) {
        super(nombre);
    }

    @Override
    public int sortear(Ronda ronda) {
        List<Integer> numerosApostados = ronda.numerosApostadosDirectos();
        numerosApostados.add(0);
        Random random = new Random();
        int indiceAleatorio = random.nextInt(numerosApostados.size());
        int enteroAleatorio = numerosApostados.get(indiceAleatorio);
        return  enteroAleatorio;
    }
    
}
