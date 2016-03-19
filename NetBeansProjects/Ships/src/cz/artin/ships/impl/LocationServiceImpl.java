/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.artin.ships.impl;

import cz.artin.ships.LocationService;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author honzik
 */
public class LocationServiceImpl implements LocationService{
    
    private final Properties property = new Properties();
    
    @Override
    public Properties load(String filePath) {
        
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(filePath);
        //if(in == null)System.out.println("Nic jsem nenasel ");
        try {
            property.load(in);
        } catch (Exception ex) {
            System.err.println("Chyba"+ex.getMessage());
        }
        return property;
        
    }
    
}
