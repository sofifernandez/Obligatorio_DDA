/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilitarios;

import Utilitarios.Observer.Evento;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sofia
 */
public abstract class Observable {
    private List<Observer> suscriptores; 
    
    public Observable(){
        suscriptores=new ArrayList();
    }
    
    public void suscribir(Observer observer){
        suscriptores.add(observer);
    }
    
    public void desuscribir(Observer observer){
        suscriptores.remove(observer);
    }
    
    public void notificar(Evento evento){
        suscriptores.forEach(s->s.actualizar(this, evento));
    }
}
