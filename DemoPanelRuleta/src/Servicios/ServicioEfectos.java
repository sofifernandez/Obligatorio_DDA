/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import Logica.Efecto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sofia
 */
public class ServicioEfectos {
    private List<Efecto> efectos;
    
    public ServicioEfectos() {
        efectos = new ArrayList();
    }

    public void agregar(Efecto efecto) {
        efectos.add(efecto);
    }
    
    public void eliminar (Efecto efecto){
        efectos.remove(efecto);
    }

    public List<Efecto> getEfectos() {
        return efectos;
    }

    public void setEfectos(List<Efecto> efectos) {
        this.efectos = efectos;
    }
    
    
}
