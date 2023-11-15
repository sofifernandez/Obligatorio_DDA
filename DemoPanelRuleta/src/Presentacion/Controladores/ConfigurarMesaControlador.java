/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion.Controladores;

import Logica.Crupier;
import Logica.Mesa;
import Logica.TipoApuesta;
import Presentacion.Interfaces.ConfigurarMesaInterface;
import Servicios.Fachada;
import java.util.List;

/**
 *
 * @author sofia
 */
public class ConfigurarMesaControlador {
    private Crupier crupier;
    private ConfigurarMesaInterface vista;

    public ConfigurarMesaControlador(Crupier crupier, ConfigurarMesaInterface vista) {
        this.crupier = crupier;
        this.vista = vista;
        this.hidratarLista();
    }
   
    private void hidratarLista() {
        List<TipoApuesta> tipos = Fachada.getInstancia().getsTiposAp().getTipos();
        this.vista.hidratarLista(tipos);
    }
    
    public void configurarMesa(List<TipoApuesta> tiposHabilitados){
            crupier.configurarMesa(tiposHabilitados);
            this.vista.siguienteVentana(crupier);
        }
}
