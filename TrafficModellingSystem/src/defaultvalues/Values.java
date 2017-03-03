package defaultvalues;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author S525973
 */
import org.json.*;

//JsonRootName(value = "values")
public class Values {
    
    private String name;
    private int carNumber;
    private double averageNumber;
    private double minimumSpeed;
    private double maximumSpeed;
    private int timeIntervals;
    private double [] percentageAtJunction;

    public Values(String name, int carNumber, double averageNumber, double minimumSpeed, double maximumSpeed, int timeIntervals, double[] percentageAtJunction) {
        this.name = name;
        this.carNumber = carNumber;
        this.averageNumber = averageNumber;
        this.minimumSpeed = minimumSpeed;
        this.maximumSpeed = maximumSpeed;
        this.timeIntervals = timeIntervals;
        this.percentageAtJunction = percentageAtJunction;
    }
    
    //@JSONProperty(value ="name")
    public void setName(String name){
        this.name=name;
    }
  
    public String getName(){
        return this.name;
    }
    public void setCarNumber(int carNumber){
        this.setCarNumber(carNumber);
    }
    public double getCarNumber(){
        return this.carNumber;
    }
    public void setAverageNumber(double averageNumber){
        this.averageNumber = averageNumber;
    }
    public double getAverageNumber(){
        return this.averageNumber;
    }
    public void setMinimumSpeed(double minimumSpeed){
         this.setMinimumSpeed(minimumSpeed);
    }
    public double getMinimumSpeed(){
        return this.maximumSpeed;
    }

    public void setMaximumSpeed(double maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

    public void setTimeIntervals(int timeIntervals) {
        this.timeIntervals = timeIntervals;
    }

    public void setPercentageAtJunction(double[] percentageAtJunction) {
        this.percentageAtJunction = percentageAtJunction;
    }
    public double getMaximumSpeed(){
        return this.maximumSpeed;
    }    
    public int getTimeIntervals(){
        return this.timeIntervals;
    }
    
    public double[] getPercentageAtJunction(){
        return this.percentageAtJunction;
    }
    
}
