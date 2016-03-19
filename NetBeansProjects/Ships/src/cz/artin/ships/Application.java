/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.artin.ships;

import cz.artin.ships.impl.LocationServiceImpl;
import cz.artin.ships.impl.ShipDefinitionServiceImpl;
import cz.artin.ships.impl.ShipServiceImpl;
import cz.artin.ships.model.Ship;

import java.util.List;

/**
 *
 * @author honzik
 */
public class Application {

        
    public static void main(String[] args) {
/*
        ShipServiceImpl shipService = new ShipServiceImpl();
        property = cesta.load("location.properties");       
        //poslat do shipServiceIMpl
        shipService.load(property.getProperty("ship.file.path"));
        
        s
       */ 
        String propertyFilePath = "location.properties";
        String propertyEl = "ship.file.path";
        LocationService locationService = new LocationServiceImpl();
        ShipDefinitionService shipDefinitionService = new ShipDefinitionServiceImpl();
        ShipService shipService = new ShipServiceImpl();
     
        List<Ship> list = shipService.createShip(shipDefinitionService.load(locationService.load(propertyFilePath).getProperty(propertyEl)));
        
        for(cz.artin.ships.model.Ship sh : list){
            System.out.println(sh);
        }
/*
        System.out.println(shipService.ships.getShip().get(0).getClazz());
        ShipParent newCruiser = null;
        try {
            
            Class trida = Class.forName(shipService.ships.getShip().get(0).getClazz());
            Class intArgsClass[] = new Class[]{String.class, int.class, int.class, int.class};
            Object[] intArgs = new Object[]{shipService.ships.getShip().get(0).getName(), 
                                            shipService.ships.getShip().get(0).getLength(), 
                                            shipService.ships.getShip().get(0).getWeight(), 
                                            shipService.ships.getShip().get(0).getWidth()};
            
            newCruiser = (ShipParent) trida.getConstructor(intArgsClass).newInstance(intArgs);
           

        } catch (ClassNotFoundException ex) {
            System.err.println("Class not found " + ex.getMessage());
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }

        SteamShip cruiser = new SteamShip("Pepa", 32, 23, 23);

        // ShipParent cruiserNovota = (ShipParent) shipService.ships.getShip().get(0).getClass();
        ShipParent ponorka = new Submarine("karel", 23, 23, 23);
        System.out.println(cruiser);
        System.out.println(ponorka);
        System.out.println(newCruiser);
*/
    }

    
}
