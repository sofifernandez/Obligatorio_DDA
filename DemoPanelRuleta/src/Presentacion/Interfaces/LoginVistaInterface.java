/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Presentacion.Interfaces;

import Logica.Usuario;

/**
 *
 * @author sofia
 */
public interface LoginVistaInterface {
    public void setearTitulo(String titulo);
    public void mostrarError(String mensaje);
    public void cerrar();
    public void abrirSiguientePantalla(Usuario usuario); //o Pasarle usuario
}
