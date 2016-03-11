/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usersystembm;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author honzik
 */
public class Datum {
    
    private static final DateFormat formatDate = new SimpleDateFormat("d.M.yyyy");
    
            
    
    public static void setMidnight(Calendar date){
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.MINUTE,0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);
    }
    
    public static String formatDate(Calendar date){
        return formatDate.format(date.getTime());
    }
    public static Calendar parseDate(String date) throws ParseException{
        Calendar kal = Calendar.getInstance();
        kal.setTime(formatDate.parse(date));
        return kal;
    }
}
