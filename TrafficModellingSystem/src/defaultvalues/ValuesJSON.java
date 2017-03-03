package defaultvalues;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
import java.io.IOException;
import static java.lang.Math.E;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author S525973
 */
public class ValuesJSON {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JSONException, FileNotFoundException {
        
       /* //JSONParser parse = new JSONParser();

         JSONObject json1 = new JSONObject("{\n" +
"   \"values\":[\n" +
"      {\n" +
"	\"name\": \"4-way\",\n" +
"	\"carsNumber\": 30,\n" +
"	\"averageSpeed\": 35,\n" +
"	\"minimumSpeed\": 25,\n" +
"	\"maximumSpeed\": 65,\n" +
"	\"timeintervals\": 1,\n" +
"	\"percentageAtThejunction\": [25,50,25] \n" +
"      },\n" +
"      {\n" +
"	\"name\": \"2-way\",\n" +
"	\"carsNumber\": 30,\n" +
"	\"averageSpeed\": 35,\n" +
"	\"minimumSpeed\": 25,\n" +
"	\"maximumSpeed\": 65,\n" +
"	\"timeintervals\": 1,\n" +
"	\"percentageAtThejunction\": [25,70] \n" +
"      },\n" +
"      {\n" +
"	\"name\": \"round-About\",\n" +
"	\"carsNumber\": 30,\n" +
"	\"averageSpeed\": 35,\n" +
"	\"minimumSpeed\": 25,\n" +
"	\"maximumSpeed\": 65,\n" +
"	\"timeintervals\": 1,\n" +
"	\"percentageAtThejunction\": [25,50,25]\n" +
"      },\n" +
"      {\n" +
"	\"name\": \"T-junction\",\n" +
"	\"carsNumber\": 30,\n" +
"	\"averageSpeed\": 35,\n" +
"	\"minimumSpeed\": 25,\n" +
"	\"maximumSpeed\": 50,\n" +
"	\"timeintervals\": 1,\n" +
"	\"percentageAtThejunction\": [75,25] \n" +
"      }\n" +
"   ]\n" +
"}");
         
         */
         Gson gson = new Gson();
         try{
             BufferedReader br = new BufferedReader(
            new FileReader("C:\\Users\\S525746\\Documents\\values"));
            Values obj = gson.fromJson(br, Values.class);
             System.out.print(obj);
         }catch(IOException e){
             e.printStackTrace();
         }
         
         /*
         List<String> newList = new ArrayList<String>();
         JSONArray array = json1.getJSONArray("values");
         for(int i=0; i<array.length() ; i++){
             newList.add(array.getJSONObject(i).getString("name"));
             
         }
          
        /* List<Integer> newList2 = new ArrayList<Integer>();
         JSONArray array1 = json1.getJSONArray("values");
         for (int i=0)*/
       
      
             
         }
          
         
         
        
        
     
       /* Iterator<E> iterator = new It;
        while (iterator.hasNext()) {
            Values value = mapper.readValue(iterator.next(), Values.class);

            System.out.println("User id=" + value.id + " data1=" + user.data1 + " data2=" + user.data2);
        */
    }

  
    

