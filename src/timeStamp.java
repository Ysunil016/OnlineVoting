/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sunil016
 */
import java.util.*;
public class timeStamp {
    public long virtualKey(){
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        long value = cal.getTimeInMillis();
        return value;
    }
}
