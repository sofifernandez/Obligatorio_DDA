/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Presentacion.Interfaces;

import java.util.List;

/**
 *
 * @author sofia
 */
public interface MesaJugadorInterface {

    public void actualizarSaldo(int saldo);

    public void actualizarNumRonda(int idRonda);

    public void actualizarNumMesa(int idMesa);

    public void actualizarNumSorteado(int numeroSorteado);

    public void setNombreJugador(String nombreCompleto);

    public void bloquearMesa();

    public void desbloquearMesa();

    public void setTiposHabilitados(List<Integer> casilleros);

    public void setCasilleros(int i);

    public void setApuesta(int cellCode, int valorFicha);

    public void mostrarError(String message);

    public void setBotonesCasilleros();

    public void limpiarMesa();
    
}
