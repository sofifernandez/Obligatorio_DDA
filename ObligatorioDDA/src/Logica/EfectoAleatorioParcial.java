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
    public int sortear() {
        
        List<Integer> ultimosNumeros =  this.ultimosTresNumerosSorteados();
        System.out.println(ultimosNumeros);
        
        Random nRandom = new Random();
        int numero = nRandom.nextInt(37);
        
        while(this.estaContenido(numero, ultimosNumeros)){
            numero =  nRandom.nextInt(37);
        }
        return numero;
        
    }
    private boolean estaContenido(int numero, List<Integer> numeros){
        return numeros.contains(numero);
    }
            
    private List<Integer> ultimosTresNumerosSorteados(){
        List<Ronda> ultimosElementos = new ArrayList();
        
        if(this.getRondas().size()<3){
            for(Ronda r: this.getRondas()){
                ultimosElementos.add(r);
            }
        } else {
            ultimosElementos = this.getRondas().subList(this.getRondas().size() - 3, this.getRondas().size());
        }
        List<Integer> ultimosTresNumeros = new ArrayList();
        
        for(Ronda numero: ultimosElementos){
            ultimosTresNumeros.add(numero.getNumeroSorteado());
        }
        return ultimosTresNumeros;
    }
    
}
