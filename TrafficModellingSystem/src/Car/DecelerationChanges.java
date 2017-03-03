
import Car.Road;
import java.util.Random;
import java.lang.IllegalArgumentException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author S525973
 */
public class DecelerationChanges {
    
    Car car;
    Road road;
    Car car1;
    Car car2;
    int brakedistance = 5;
    
    public int RandomNumber(){  
        Random ran = new Random();
        int x = ran.nextInt(10);
        return x;
        
    }
    
    public int decelerate(int speed){
        int x = speed-RandomNumber();
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
    
    public void brake() throws Exception{
        int car1Speed=car1.getSpeed();
        int car2Speed=car2.getSpeed();
        int x;
        if (car1Speed < car2Speed){
           x = decelerate(car2Speed);
        }
        else{
            Exception IllegalArgumentException = null;
            throw IllegalArgumentException;
        }
        
        this.brakedistance = brakedistance;
    }
}
