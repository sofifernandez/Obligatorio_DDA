/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Presentacion.Interfaces;

import Logica.Crupier;
import Logica.Mesa;
import Logica.TipoApuesta;
import java.util.List;

/**
 *
 * @author sofia
 */
public interface ConfigurarMesaInterface {
    public void hidratarLista(List<TipoApuesta> tipos);
    public void siguienteVentana(Crupier crupier);
}
