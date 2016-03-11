/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usersystembm;

/**
 *
 * @author honzik
 */
public class Person {
    private String name;
    private int id;
    private String email;

    public Person(String name, int id, String email) {
        this.name = name;
    //    this.surname = surname;
        this.id = id;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }
/*
    public void setSurname(String surname) {
        this.surname = surname;
    }
*/
    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }
/*
    public String getSurname() {
        return surname;
    }
*/
    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
