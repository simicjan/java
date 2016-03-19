/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.artin.ships.model;

/**
 * Define properties of all ships 
 * @author Jan Simicek
 */
public interface Ship {
    String getName();
    
    int getDeckArea();

    int getWeight();
    
    int getDateOfCreation();
    
    boolean isWarShip();
    
    boolean isSurfaceShip();
    
}
