/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t1_carrera_caballos;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author crist
 */
public class CarreraCaballo extends Observable implements Runnable {

    public String nombre;

    public CarreraCaballo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    

    
    @Override
    public void run() {

        int carreraCaballo = 0;
        int numeroAleatorio;
        try {
            while (carreraCaballo < 100) {

                numeroAleatorio = getNumeroAle(1, 15);
                System.out.println("Caballo " + nombre + " aumento en :" + numeroAleatorio);
                carreraCaballo += numeroAleatorio;

                this.setChanged();
                this.notifyObservers(carreraCaballo);
                this.clearChanged();

                Thread.sleep(1000);
            }

        } catch (InterruptedException ex) {
            System.out.println("El hilo fue interrumpido");
        }
    }

    public static int getNumeroAle(int minimo, int maximo) {
        int numero = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
        return numero;
    }

}
