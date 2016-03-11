/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

/**
 * Set a query for mysql database
 * @author honzik
 */
public class Query {
    private StringBuilder query;
    
    /**
     * delete from 
     * @param table
     * @return DELETE from *table
     */
    public Query delete(String table){
        query = new StringBuilder();
        query.append("DELETE FROM ").append(table);
        return this;
    }
    /**
     * 
     * @param table
     * @return from table 
     */
    public Query from(String table){
        query.append(" FROM ").append(table);
        return this;
    }
    /**
     * where
     * @param requirements
     * @return  WHERE *req
     */
    public Query where(String requirements){   
        query.append(" WHERE ").append(requirements);
        return this;
    }
    /**
     * 
     * @param table
     * @return UPDATE table SET
     */
    public Query update(String table){
        query = new StringBuilder();
        query.append("UPDATE ").append(table).append(" SET ");
        return this;
    }
    /**
     * set
     * @param columns
     * @return column = ?, column" = ? .... 
     */
    public Query set(String[] columns){
        if(columns.length == 0){
            throw new IllegalArgumentException("Neplatny pocet parametru");
        }else{
            for(String column : columns){
                query.append(column).append(" = ").append("?").append(",");
            }
            query.deleteCharAt(query.lastIndexOf(","));
            // plynule rozhrani (fluent interface) pri volani je mozne retezit volani metod stejneho objektu
            return this;
        }       
    }
    /**
     * insert
     * @param table
     * @return INSERT INTO table
     */
    public Query insert(String table){
        query = new StringBuilder();
        query.append("INSERT INTO ").append(table);
        return this;
    }
    /**
     * 
     * @param params
     * @return VALUES(?,?,?....?);
     */
    public Query values(Object[] params){
        query.append(" VALUES (");
        if(params.length == 0){
            throw new IllegalArgumentException("Neplatny pocet parametru");
        }
        //according to count of parameters insert ?
        for (Object param : params) {
            query.append("?,");
        }
        query.deleteCharAt(query.lastIndexOf(","));
        query.append(");");
        return this;
    }
    /**
     * select
     * @param columns
     * @return SELECT column,...... or *
     */
    public Query select(Object[] columns){
        query = new StringBuilder();
        query.append("SELECT ");
        if(columns != null){
            for (Object column : columns){
                query.append(column).append(",");
            }
            query.deleteCharAt(query.lastIndexOf(","));
        } else {
            query.append("*");
        }
        return this;
    }
    /**
     * 
     * @return (String)query
     */
    public String getQuery(){
        return query.toString();
    }
}
