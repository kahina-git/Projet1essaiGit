/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Date;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 *
 * @author Karima
 */
public class Utilitaire {
public static JSONObject CreerJson(JSONArray shapesList, String name, double base, double heigth) {
        JSONObject shape = new JSONObject();
        Date date = new Date();
        long timestamp = date.getTime();
        JSONObject jsonObject;
        boolean exist = false;

        for (int i = 0; i < shapesList.size(); i++) {

            jsonObject = shapesList.getJSONObject(i);

            if (jsonObject.getString("name").equalsIgnoreCase(name)) {
                exist = true;
                break;
            }
        }
        
       

        if (exist) {
            shape.accumulate("Status", "OK");
            shape.accumulate("Timestamp", timestamp);
            shape.accumulate("Shape", name.toUpperCase());
            shape.accumulate("Width", base);
            shape.accumulate("height", heigth);
            shape.accumulate("Area", CalculerArea(name,base,heigth));
        } else {

            shape.accumulate("Status", "ERROR");
            shape.accumulate("Timestamp", timestamp);
            shape.accumulate("Shape", name.toUpperCase());
            shape.accumulate("Message", "Not the good Shape");
        }

        return shape;

    }

    
     private static double CalculerArea(String name, double val1, double val2){
           double area=0; 
           
         if (name.equalsIgnoreCase("Triangle")){
             area = 0.5 * val1 * val2;
         }
         
         if (name.equalsIgnoreCase("Rectangle") || name.equalsIgnoreCase("Parallelogram")){
             area = val1 * val2;
         
         }
         if (name.equalsIgnoreCase("Ellipse")){
             area = 3.14 * val1 * val2;
         }
         
                
         return area;
        }
}


