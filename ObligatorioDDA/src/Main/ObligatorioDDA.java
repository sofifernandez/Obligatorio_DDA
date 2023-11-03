/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Logica.TipoApuestaColor;
import Logica.TipoApuestaDirecta;
import Logica.TipoApuestaDocena;
import Logica.Casillero;
import Logica.Crupier;
import Logica.Efecto;
import Logica.EfectoAleatorioCompleto;
import Logica.EfectoAleatorioParcial;
import Logica.EfectoSimulador;
import Logica.Jugador;
import Logica.Mesa;
import Logica.TipoApuesta;
import Presentacion.A_Inicio;
import Servicios.Fachada;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class ObligatorioDDA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            cargarDatosBase();
            //new A_Inicio().setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
     private static void cargarDatosBase() {
        Fachada f = Fachada.getInstancia();

       

        
        
 
        
        //Los casilleros conocen el tipo de apuesta o el tipo de apuesta conoce sus casillero?
        
    
 
        
        
        //AGREGAR SERVICIOtIPOAPUESTAS
        //TIPOS DE APUESTA---------------------------------------------
        TipoApuestaDirecta tipoDirecto= new TipoApuestaDirecta(36, "DIRECTA" );
        TipoApuestaColor tipoColor= new TipoApuestaColor(2, "COLOR");
        TipoApuestaDocena tipoDocena=new TipoApuestaDocena(3, "DOCENA");
        
        //CASILLEROS---------------------------------------------------
        //INDIVIDUALES:   del 0 al 36  
        List<Casillero> todosLosCasilleros= new ArrayList();
        for(int i=0; i<37; i++){
            int[] arrayNum={i};
            todosLosCasilleros.add(new Casillero(i, arrayNum,tipoDirecto));
        }
        
        // GRUPALES
        int[] arrayRojos={1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
        int[] arrayNegros={2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35};
        int[] arrayPrimeraDocena={1,2,3,4,5,6,7,8,9,10,11,12};
        int[] arraySegundaDocena={13,14,15,16,17,18,19,20,21,23,24};
        int[] arrayTerceraDocena={25,26,27,28,29,30,31,32,33,34,35,36};
        
        Casillero rojos=new Casillero(43, arrayRojos,tipoColor);
        Casillero negros= new Casillero(44, arrayNegros,tipoColor);
        Casillero primeraDocena= new Casillero(40,arrayPrimeraDocena,tipoDocena );
        Casillero segundaDocena= new Casillero(41,arraySegundaDocena,tipoDocena );
        Casillero terceraDocena= new Casillero(42,arrayTerceraDocena,tipoDocena );
        
        todosLosCasilleros.add(rojos);
        todosLosCasilleros.add(negros);
        todosLosCasilleros.add(primeraDocena);
        todosLosCasilleros.add(segundaDocena);
        todosLosCasilleros.add(terceraDocena);

        tipoDirecto.configurarCasilleros(todosLosCasilleros);
        tipoColor.configurarCasilleros(todosLosCasilleros);
        tipoDocena.configurarCasilleros(todosLosCasilleros);
        
//        System.out.println(tipoDirecto);
//        System.out.println(tipoColor);
//        System.out.println(tipoDocena);
//               

        
         // JUGADORES---------------------------------------------
        Jugador j1 = new Jugador("201", "aaa");
        j1.setSaldo(1000);
        j1.setNombreCompleto("Walter White");
        
        Jugador j2 = new Jugador("202", "bbb");
        j2.setSaldo(500);
        j2.setNombreCompleto("Jessie Pinkman");
        
        Jugador j3 = new Jugador("203", "ccc");
        j3.setSaldo(100);
        j3.setNombreCompleto("Gustavo Fring");
        
        f.agregar(j1);
        f.agregar(j2);
        f.agregar(j3);
        
        //CRUPIERS-------------------------------------------------
        Crupier c1= new Crupier("101", "aaa");
        //c1.setMesa();
        c1.setNombreCompleto("Saul Goodman");
        
        Crupier c2= new Crupier("102", "bbb");
        //c2.setMesa();
        c2.setNombreCompleto("Hank Shrader");
        
        Crupier c3= new Crupier("103", "ccc");
        //c3.setMesa();
        c3.setNombreCompleto("Mike Ehrmantraut");
        
        f.agregar(c1);
        f.agregar(c2);
        f.agregar(c3);
        
        //agregar ServicioEfectos
        
        Efecto aleartorioCompleto= new EfectoAleatorioCompleto("COMPLETO");
        Efecto aleartorioParcial= new EfectoAleatorioParcial("PARCIAL");
        Efecto aleartorioSimulador= new EfectoSimulador("SIMULADOR");
        
        //SORTEAR
        //cargarle mesa, configurar mesa, setear efecto, lanzar, pagar
        
               
        
        
        //vista setear mesa
        // Mesa, Crupier, Lista<TiposApuesta>
        //  crupier.configurarMesa(tiposHabilitados).
        
                
        //Las mesas se asignan a los crupiers en la precarga
        Mesa mesa1=new Mesa(tipoDirecto); //inicializar saldo en 0
        f.agregar(mesa1);
        
        //1) Login exitoso, agregarle mesa
        c1.setMesa(mesa1);
        //2) En la ventana para configurar la mesa
                // traer tipos de apuesta desde servicio
        List<TipoApuesta> tiposHabilitados =new ArrayList<>();
        tiposHabilitados.add(tipoDocena);
        c1.configurarMesa(tiposHabilitados);
       
        //3) se carga el panel, hidratar con tipo de efecto
        //4) seleccionar efecto y lanzar.
        c1.lanzar(aleartorioCompleto);
        c1.lanzar(aleartorioCompleto);
        c1.lanzar(aleartorioCompleto);
        c1.lanzar(aleartorioCompleto);
        System.out.println(c1.getMesa().getRondas());
        System.out.println("\n");
        c1.lanzar(aleartorioParcial);
        c1.lanzar(aleartorioParcial);
        c1.lanzar(aleartorioParcial);
        
        
        //Unirse a una mesa
        j1.unirseAMesa(mesa1);
     }
}
