/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package supermarket.mvc;

import supermarket.mvc.view.CustomerView;
import supermarket.mvc.view.ItemView;

/**
 *
 * @author user
 */
public class SupermarketMvc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new CustomerView().setVisible(true);
        new ItemView().setVisible(true);
    }
    
}
