package Car;


import Car.Road;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author S525973
 */
public class AccelerationChanges {
    
    Car car;
    Road road;
    
    public int RandomNumber(){  
        Random ran = new Random();
        int x = ran.nextInt(10);
        return x;
        
    }
    
    public int accelerate(int speed){
        int x = RandomNumber()+speed;
        if( x < road.getSpeedLimit()+5 && x > road.getSpeedLimit()-5)
        {
            x=x;
        }
        else
        {
            x=speed;
        }
      return x;
    }
    
    
    
}