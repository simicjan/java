/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.artin.ships.model;

/**
 *
 * @author honzik
 */
public class SteamShip extends ShipParent {
    
    public SteamShip(String name, int deckArea, int weight, int dateOfCreation) {
        super(name, deckArea, weight, dateOfCreation, false, true);
    }
    
}
