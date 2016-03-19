/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.artin.ships;

import cz.artin.ships.model.Ship;
import cz.artin.ships.gen.Ships;
import java.util.List;

/**
 * Servuce for working with ships
 * @author honzik
 */
public interface ShipService {
    /**
     * Method creates ships from XML representation
     * @param ships XML representation
     * @return List of {@link Ships}
     */
    List<Ship> createShip(Ships ships);
}
