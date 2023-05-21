/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programasps;

import programasps.frontend.*;

/**
 *
 * @author dnrahmath
 */
public class programasps {
        
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //versi-1
        //AaGuestPanel gP = new AaGuestPanel();//belum otomatis setVisible true
        //gP.setDefaultCloseOperation(gP.EXIT_ON_CLOSE); 
        //gP.setVisible(true);
                
        //versi-2
        AaHomePanel hP = new AaHomePanel();
        hP.setDefaultCloseOperation(hP.EXIT_ON_CLOSE); 
        hP.setVisible(true);
        
        //login in = new login();
        //in.setVisible(true);
        //in.setDefaultCloseOperation(in.EXIT_ON_CLOSE);
        
    }
}
