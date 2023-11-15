/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilitarios;

/**
 *
 * @author sofia
 */
public interface Observador {
    
    public enum Evento{
        LISTADO_MESAS_MODIFICADO,
        LISTADO_JUGADORES_MODIFICADO,
        SORTEO_REALIZADO,
        DATOS_MESA_ACTUALIZADOS,
   
        
        APUESTA_ACTUALIZADA
    }
    public void actualizar(Observable origen, Evento evento);
}
