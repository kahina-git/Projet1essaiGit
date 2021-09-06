/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageWS;

import java.util.Date;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import net.sf.json.JSONObject;

/**
 * REST Web Service
 *
 * @author Utilisateur
 */
@Path("shape")
public class BdebResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of BdebResource
     */
    public BdebResource() {
    }

    /**
     * Retrieves representation of an instance of packageWS.BdebResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("shapeOne&{nameOfShape}&{value1}")
    @Produces(MediaType.APPLICATION_JSON)
    public String circleArea(@PathParam("nameOfShape") String nameShape,@PathParam("value1") double radius) {
       
        double area;
        JSONObject circleJSON=new JSONObject();
           Date date = new Date();
        long timestamp = date.getTime();
        circleJSON.accumulate("Status", "OK");
        circleJSON.accumulate("timestamp", timestamp);
        circleJSON.accumulate("Shape", nameShape.toUpperCase());
          
            
       if("CIRCLE".equals(nameShape.toUpperCase()))
        { 
            area = Math.pow(radius, 2) * Math.PI;
            
            
            circleJSON.accumulate("radius", radius);
            circleJSON.accumulate("area", area);
            
        return circleJSON.toString();}
        else{
          circleJSON.put("Status", "ERROR"); 
           circleJSON.accumulate("Message", "Not the good Shape"); 
            return circleJSON.toString();
       }
            
           /* return"{\n" +
"	\"Status\": \"Error\",\n" +
"	\"Timestamp\": 12255645,\n" +
"	\"Shape\": \"CIRRCLE\",\n" +
"	\"Message\": \"Not the good Shape\"\n" +
"}";  
                }*/
    }
        
    }

    
    

