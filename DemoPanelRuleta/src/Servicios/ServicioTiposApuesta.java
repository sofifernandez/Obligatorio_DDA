/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import Logica.TipoApuesta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sofia
 */
public class ServicioTiposApuesta {
    List<TipoApuesta> tipos;

    public ServicioTiposApuesta() {
        this.tipos = new ArrayList();
    }

    public List<TipoApuesta> getTipos() {
        return tipos;
    }

    public void setTipos(List<TipoApuesta> tipos) {
        this.tipos = tipos;
    }
    
    
    public void agregar(TipoApuesta tipo) {
        tipos.add(tipo);
    }
    
}
