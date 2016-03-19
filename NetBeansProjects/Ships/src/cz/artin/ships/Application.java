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
import java.util.Collections;
import java.util.Comparator;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author honzik
 */
public class Application implements Runnable {
    //ochrana proti prazdnemu dokumentu
    //vyjimky
    public static void main(String[] args) {

        Thread thread = new Thread(new Application());
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("----Finish---------");
    }

    @Override
    public void run() {
        String propertyFilePath = "location.properties";
        String propertyEl = "ship.file.path";
        LocationService locationService = new LocationServiceImpl();
        ShipDefinitionService shipDefinitionService = new ShipDefinitionServiceImpl();
        ShipService shipService = new ShipServiceImpl();

        List<Ship> list = shipService.createShip(shipDefinitionService.load(locationService.load(propertyFilePath).getProperty(propertyEl)));
        //pocet lodi
        System.out.println("---Number of ships------------");
        System.out.println(list.size());

        //
        sleepASec();

        System.out.println("---Deckarea sort-------------");
        //sort list
        Collections.sort(list, new Comparator<Ship>() {
            @Override
            public int compare(final Ship lhs, Ship rhs) {
                if (lhs.getDeckArea() > rhs.getDeckArea()) {
                    return 1;
                } else if (lhs.getDeckArea() < rhs.getDeckArea()) {
                    return -1;
                }
                return 0;
            }
        });
        for (Ship sh : list) {
            System.out.println(sh);
        }

        //
        sleepASec();

        System.out.println("---Days between the youngest and the oldest ship---");
        //count diff
        System.out.println(countDiff(list));

        //
        sleepASec();

        System.out.println("---Group by ship type---");

        //
        sleepASec();

        System.out.println("---Average weight of all ship-------");
        System.out.format("%.3f\n", averageWeight(list));
    }

    private Double averageWeight(List<Ship> list) {
        Double totWeight = 0d;
        for (Ship ship : list) {
            totWeight += ship.getWeight();
        }
        return totWeight / list.size();
    }

    private void sleepASec() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.err.println("Nepodarilo se uspat vlakno: " + ex);
        }
    }
    
    private long countDiff(List<Ship> list){
        long diff = 0;
        Ship oldest = list.get(0);
        Ship newest = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getDateOfCreation().before(newest.getDateOfCreation())){
                newest = list.get(i);
            }
            
            if(list.get(i).getDateOfCreation().after(oldest.getDateOfCreation())){
                oldest = list.get(i);
            }
            
        }
        
        diff = oldest.getDateOfCreation().getTime() - newest.getDateOfCreation().getTime();
       
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
}
