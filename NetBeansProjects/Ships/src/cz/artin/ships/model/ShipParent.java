/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.artin.ships.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author honzik
 */
public class ShipParent implements Ship{
   
    private final String name;
    private final int deckArea;
    private final int weight;
    
    private final Date dateOfCreation;
    private final boolean warShip;
    private final boolean surfaceShip;
    DateFormat formatData = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy",Locale.ENGLISH);

    public ShipParent(String name, int weight, int length, int width, Date dateOfCreation, boolean warShip, boolean surfaceShip) {
        this.name = name;
        this.deckArea = length * width;
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
    public Date getDateOfCreation() {
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
        return "AbstractShip [" + "getName()=" + name + ", getDeckArea()=" + deckArea + ", getWeight()=" + weight + ", getDateOfCreation()=" + formatData.format(dateOfCreation) + ", isWarShip()=" + warShip + ", isSurfaceShip()=" + surfaceShip + ']';
    }

    
}
