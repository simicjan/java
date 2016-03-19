/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.artin.ships.impl;

import cz.artin.ships.ShipDefinitionService;
import cz.artin.ships.gen.Ships;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author honzik
 */
public class ShipDefinitionServiceImpl implements ShipDefinitionService {

   
    private Ships ship;
    
    @Override
    public Ships load(String xmlFilePath) {
        
        try {
            File file = new File(xmlFilePath);
           
            JAXBContext jaxbContext = JAXBContext.newInstance(Ships.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            ship = (Ships) jaxbUnmarshaller.unmarshal(file);
           

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return ship;
    }
}
