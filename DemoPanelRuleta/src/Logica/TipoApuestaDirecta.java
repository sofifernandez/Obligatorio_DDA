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
public class TipoApuestaDirecta extends TipoApuesta{
    
    public TipoApuestaDirecta(int factorDePago, String nombre) {
        super(factorDePago, nombre);
    }

    @Override
    public void validarApuesta(Ronda rondaActual, Apuesta apuesta) {
    }
    
}
