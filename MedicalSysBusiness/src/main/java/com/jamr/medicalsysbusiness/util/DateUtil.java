
package com.jamr.medicalsysbusiness.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static Date stringToDate(String date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");
        
        
        try {
            return simpleDateFormat.parse(date);
            
        } catch (ParseException e) {
           e.printStackTrace();
           return null;
        }
    }
}
