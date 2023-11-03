/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.List;

/**
 *
 * @author lucas
 */
public class Crupier extends Usuario {
   private Mesa mesa;

    public Crupier(String cedula, String password) {
        super(cedula, password);
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
    
    public void configurarMesa(List<TipoApuesta> tipos){
        this.mesa.agregarTipoApuesta(tipos);
    }
    
    public void lanzar(Efecto efecto){
        this.mesa.nuevaRonda(efecto);
    }
    

    
    
   
   
}
