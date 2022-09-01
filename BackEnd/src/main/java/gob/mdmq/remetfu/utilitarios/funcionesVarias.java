/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.utilitarios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author srcisnerosv
 */
public class funcionesVarias {
    
public Date StringToDate(String s){

    Date result = null;
    try{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        result  = dateFormat.parse(s);
    }

    catch(ParseException e){
        e.printStackTrace();

    }
    return result ;
}  

    
}



