/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * interface for database
 * @author honzik
 */
public class Database {
    protected Connection connection;
    protected Query query;

    //vhodne pro deskopove apk, pri apk pro net pripojovat v kazde metode zvlast viz. slovnicek
    public Database(String db, String userName, String pass) throws SQLException {
       
        connection = DriverManager.getConnection("jdbc:mysql://localhost/"+db, userName, pass);
    }
    /**
     * 
     * @param query
     * @param params
     * @return pocet ovlivnenych radku
     * @throws SQLException 
     */
    private int query(String query, Object[] params) throws SQLException{
        PreparedStatement ps = connection.prepareStatement(query);
        if(params != null){
            int index = 1;
            for (Object param : params){
                ps.setObject(index, param);
                index++;
            }
        }
        return ps.executeUpdate();
    }
    /**
     * 
     * @param table
     * @param requirement
     * @param param
     * @return delete from table where ... 
     * @throws SQLException 
     */
    public int delete(String table, String requirement, Object[] param) throws SQLException{
        query = new Query();
        query.delete(table).where(requirement);
        return query(query.getQuery(), param);
    }
   
    /**
     * 
     * @param table
     * @param params
     * @return insert into table params
     * @throws SQLException 
     */
    public int insert(String table, Object[] params) throws SQLException{
        query = new Query();
        query.insert(table).values(params);
        return query(query.getQuery(),params);
    }
    /**
     * 
     * @param table
     * @param columns
     * @param requirements
     * @param params
     * @return update query
     * @throws SQLException 
     */
    public int update(String table, String[] columns, String requirements, Object[] params) throws SQLException{
        query = new Query();
        query.update(table).set(columns).where(requirements);
        return query(query.getQuery(),params);
    }
    /**
     * 
     * @param table
     * @param columns
     * @param requirements
     * @param params
     * @return select columns from table where
     * @throws SQLException 
     */
    public ResultSet select(String table, Object[] columns, String requirements, Object[] params) throws SQLException{
        query = new Query();
        query.select(columns).from(table).where(requirements);
        PreparedStatement ps = connection.prepareStatement(query.getQuery());
        if(params != null){
            int index = 1;
            for (Object param : params){
                ps.setObject(index, param);
                index++;
            }
        }
         
        ResultSet rs = ps.executeQuery();
        return rs;
    }
   
    /**
     *
     * @param table
     * @return
     * @throws SQLException
     */
    public int count(String table) throws SQLException{
        PreparedStatement ps = connection.prepareStatement("SELECT COUNT(*) FROM "+table);
        ResultSet result = ps.executeQuery();
        result.next();
        return result.getInt(1);
    }
}
