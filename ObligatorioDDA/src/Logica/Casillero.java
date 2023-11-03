/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.List;

/**
 *
 * @author lucas
 */
public class Casillero {
    private int codUniversal;
    private int[] numerosAsociados;
    private TipoApuesta tipo;

    public Casillero(int codUniversal, int[] numerosAsociados, TipoApuesta tipo) {
        this.codUniversal = codUniversal;
        this.numerosAsociados = numerosAsociados;
        this.tipo=tipo;
    }
    
    public boolean contieneValor(int x){
        for(int i=0;i<this.numerosAsociados.length; i++){
            if(numerosAsociados[i] == x){
                return true;
            }
        }
        return false;
    }

    public int getCodUniversal() {
        return codUniversal;
    }

    public void setCodUniversal(int codUniversal) {
        this.codUniversal = codUniversal;
    }

    public int[] getNumerosAsociados() {
        return numerosAsociados;
    }

    public void setNumerosAsociados(int[] numerosAsociados) {
        this.numerosAsociados = numerosAsociados;
    }

    @Override
    public String toString() {
        return "Casillero{" + "codUniversal=" + codUniversal + '}';
    }

    public TipoApuesta getTipo() {
        return tipo;
    }

    public void setTipo(TipoApuesta tipo) {
        this.tipo = tipo;
    }
    
    public boolean esDirecto(){
        return this.getTipo().getNombre().equals("DIRECTO");
    }
    
    
    
    
    
    
    
  
}
