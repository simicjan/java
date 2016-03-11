/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usersystembm;

import DB.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author honzik
 */
//get,add,delete,found
public class PersonManager {
    
    private ObservableList<Person> persons = FXCollections.observableArrayList();
    private Database database;
    
    public PersonManager(){
        try {
            database = new Database("datBM","root","KrPsSd1k");
        } catch (SQLException ex) {
            System.err.println("Chyba pripojeni databaze, spojeni selhalo");
            System.err.println(ex.getMessage());
        }
    }
   //osetreni vyjimky 
    public ObservableList<Person> getPersons() throws SQLException {
        
            refreshList();
      
        return persons;
    }
    
    public String getName(Person person){
        return person.toString();
    }
    
    public String getEmail(Person person){
        return person.getEmail();
    }
    
    public void addPerson(String name, String email) throws SQLException{
        Object[] params = {null, name, email};
        database.insert("users", params);
        refreshList();
        
    }

    private void refreshList() throws SQLException {
        persons.clear();
        String[] columns = {"*"};
        
        ResultSet rs = database.select("users", columns,"1", null);
        try {
            while(rs.next()){
                Person person = new Person(rs.getString("name"),Integer.valueOf(rs.getString("userID")),rs.getString("email"));
                persons.add(person);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }       
    }
}
