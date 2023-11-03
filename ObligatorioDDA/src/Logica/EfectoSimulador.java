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
public class EfectoSimulador extends Efecto {

    public EfectoSimulador(String nombre) {
        super(nombre);
    }

    @Override
    public int sortear() {
        Ronda ultimaRonda= this.getRondas().get(this.getRondas().size());
        List<Integer> numerosApostados = ultimaRonda.numerosApostadosDirectos();
        Random random = new Random();
        int indiceAleatorio = random.nextInt(numerosApostados.size());
        int enteroAleatorio = numerosApostados.get(indiceAleatorio);
        return  enteroAleatorio;
    }
    
}
