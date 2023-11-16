/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Excepciones.ApuestaInvalidaException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class TipoApuestaDocena extends TipoApuesta{
    
    public TipoApuestaDocena(int factorDePago, String nombre) {
        super(factorDePago, nombre);
    }

    @Override
    public void validarApuesta(Apuesta apuesta)throws ApuestaInvalidaException {
        JugadorMesa jm= apuesta.getJugadorMesa();
        Ronda ronda= apuesta.getRonda();
        if(chequearRestriccionDocenas(jm, ronda)){
            throw new ApuestaInvalidaException("No se puede apostar a mas de una docena por ronda");
        }
    }
    
    
    private boolean chequearRestriccionDocenas(JugadorMesa jm,Ronda ronda) { //Restricciones: no se puede apostar a más de una docena por ronda.
        for (Apuesta a : jm.getApuestas()) {
            if (a.esDocena() && a.getRonda().equals(ronda)) {
                return true;
            }
        }
        return false;
    }

 
    
    
}
