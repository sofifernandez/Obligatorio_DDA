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
        MESA_BLOQUEADA,
        MESA_CERRADA,
        LISTADO_JUGADORES_MODIFICADO,
        SORTEO_REALIZADO,
        BALANCE_ACTUALIZADO,
        
        
        APUESTAS_MODIFICADAS
    }
    public void actualizar(Observable origen, Evento evento);
}
