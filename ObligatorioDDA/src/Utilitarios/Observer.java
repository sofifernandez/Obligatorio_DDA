/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilitarios;

/**
 *
 * @author sofia
 */
public interface Observer {
    
    public enum Evento{
        ALGUNA_COSA,
        OTRA_COSA
    }
    public void actualizar(Observable origen, Evento evento);
}
