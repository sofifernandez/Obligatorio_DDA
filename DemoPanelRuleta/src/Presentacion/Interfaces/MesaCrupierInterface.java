/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Presentacion.Interfaces;

import Logica.Efecto;
import java.util.List;

/**
 *
 * @author sofia
 */
public interface MesaCrupierInterface {

    public void setCasilleros(int i);

    public void actualizarNumRonda(int idRonda);

    public void actualizarNumMesa(int idMesa);

    public void actualizarNumSorteado(int numeroSorteado);

    public void setTiposHabilitados(List<Integer> casilleros);

    public void setApuesta(int codUniversal, int totalApostado);

    public void actualizarTextoBoton(String titulo);

    public void hidratarListaEfectos(List<Efecto> efectos);

    public void bloquearMesa();

    public void desbloquearMesa();

    public void limpiarMesa();
    
}
