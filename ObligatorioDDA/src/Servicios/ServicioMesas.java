/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import Logica.Casillero;
import Logica.Mesa;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sofia
 */
public class ServicioMesas {
     List<Mesa> mesas;

    public ServicioMesas() {
        mesas = new ArrayList();
    }

    public void agregar(Mesa mesa) {
        mesas.add(mesa);
    }
}
