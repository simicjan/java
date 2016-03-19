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
public class ShipParent implements Ship{
   
    private final String name;
    private final int deckArea;
    private final int weight;
    private final int dateOfCreation;
    protected final boolean warShip;
    protected final boolean surfaceShip;

    public ShipParent(String name, int deckArea, int weight, int dateOfCreation, boolean warShip, boolean surfaceShip) {
        this.name = name;
        this.deckArea = deckArea;
        this.weight = weight;
        this.dateOfCreation = dateOfCreation;
        this.warShip = warShip;
        this.surfaceShip = surfaceShip;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDeckArea() {
        return deckArea;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public int getDateOfCreation() {
        return dateOfCreation;
    }

    @Override
    public boolean isWarShip() {
        return warShip;
    }

    @Override
    public boolean isSurfaceShip() {
        return surfaceShip;
    }

    @Override
    public String toString() {
        return "ShipParent{" + "name=" + name + ", deckArea=" + deckArea + ", weight=" + weight + ", dateOfCreation=" + dateOfCreation + ", warShip=" + warShip + ", surfaceShip=" + surfaceShip + '}';
    }

    
}
