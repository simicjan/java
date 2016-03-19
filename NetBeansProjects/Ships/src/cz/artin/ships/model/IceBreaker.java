/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.artin.ships.model;

import java.util.Date;

/**
 *
 * @author honzik
 */
public class IceBreaker extends ShipParent{

    public IceBreaker(String name, int weight, int length, int width, Date dateOfCreation) {        
        super(name, weight, length, width, dateOfCreation, false, true);
    }

    
    
}
