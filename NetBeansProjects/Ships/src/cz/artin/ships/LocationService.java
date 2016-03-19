/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.artin.ships;

import java.util.Properties;

/**
 * Service servers for loading information from property files
 * @author Jan Simicek
 */
public interface LocationService {
    /**
     * Method loads property file
     * @param filePath
     * @return Property file
     */
    Properties load(String filePath);
}
