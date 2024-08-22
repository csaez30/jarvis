/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jarvis;

/**
 *89
 * @author JuanJo
 */
public class WarMachine {
      private int misiles=10000;
      private String armaEquipada;

    public WarMachine(String armaEquipada) {
        this.armaEquipada = armaEquipada;
    }
      
      public void   SaludarYDisparar(){
          System.out.println("Arma equipada: "+ armaEquipada);
          System.out.println("Hola y Adios..."+ Disparar() + " misiles disparados al blanco.");
          
      }
      private int Disparar(){
          return 9999;
      }
}
