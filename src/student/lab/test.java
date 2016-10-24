/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.lab;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;

/**
 *
 * @author jstra
 */
public class test {
    
    
   
    
    public static void main(String[] args) {
        DateUtilities du = DateUtilities.getInstance();
         LocalDateTime date1 = LocalDateTime.now();
         LocalDate date2 = LocalDate.now();
         
         LocalDate date3 = du.toDate("2016-07-07");
        System.out.println(du.toString(date1));
        System.out.println(du.toString(date2));
        System.out.println(du.toString(date1,"MM/dd/yyyy"));
        
        String dateString = "2016-11-30 12:30";
        String format = "yyyy-MM-dd HH:mm";
      // LocalDate dateS = du.toDate(dateString,format);
       //System.out.println(du.toString(dateS,format));
       
       LocalDateTime d = du.toDateTime(dateString,format);
       LocalDateTime s = du.toDateTime("2011-12-03T10:15:30");
        System.out.println(du.toString(s));
      Duration diff = du.diff(d, date1);
        System.out.println(du.diffInWeek(d, s));
     
    }
}
