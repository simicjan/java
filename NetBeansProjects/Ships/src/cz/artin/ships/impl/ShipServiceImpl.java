/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.artin.ships.impl;

import cz.artin.ships.ShipService;
import cz.artin.ships.gen.Ships;
import cz.artin.ships.model.Ship;
import cz.artin.ships.model.ShipParent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author honzik
 */
public class ShipServiceImpl implements ShipService{
    
  
    @Override
    public List<Ship> createShip(Ships ships) {
        
        
        
        List<Ships.Ship> listShipsIn = ships.getShip();
        List<Ship> listShipsOut = new ArrayList<>();
        //for(Ships.Ship ship : listShipsIn){
        listShipsIn.stream().forEach((ship) -> {
            try {
                Class trida = Class.forName(ship.getClazz());
                Class intArgsClass[] = new Class[]{String.class, int.class, int.class, int.class};
                Object[] intArgs = new Object[]{ship.getName(),
                    ship.getLength(),
                    ship.getWeight(),
                    ship.getWidth()};
                
                ShipParent shipObject = (ShipParent) trida.getConstructor(intArgsClass).newInstance(intArgs);
                listShipsOut.add(shipObject);
                
            } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(ShipServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        return listShipsOut;
    }

}
