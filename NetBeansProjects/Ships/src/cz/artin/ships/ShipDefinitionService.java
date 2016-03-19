/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.artin.ships;
import cz.artin.ships.gen.Ships;

/**
 * Service serves for loading ships definitions from XML file
 * @author honzik
 */
public interface ShipDefinitionService {
    /**
     * Method loads ships definitions
     * @param xmlFilePath
     * @return {@link Ships}
     */
    Ships load(String xmlFilePath);
}
