/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Presentacion.Interfaces;

import Logica.JugadorMesa;
import Logica.Mesa;
import java.util.List;

/**
 *
 * @author lucas
 */
public interface MesasDisponiblesInterface {
    
    public void hidratarLista(List<Mesa> mesas);
    
    public void siguienteVentana(JugadorMesa jm);

    public void mostrarError(String message);
}
