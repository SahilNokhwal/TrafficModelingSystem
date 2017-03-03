/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lights;

import java.util.List;

/**
 *
 * @author S525746
 */
public interface CarDirectionInterface {
     public void setNextNorthSouthRoad(CarDirectionInterface road);

	public void setNextEastWestRoad(CarDirectionInterface road);

	public CarDirectionInterface getNextNorthSouthRoad();

	public CarDirectionInterface getNextEastWestRoad();

	

	public void acceptCar(Car car, double frontPosition);

	public List<Car> getCars();

	public double distanceToStop(Car car, double fromPosition);

	public CarDirectionInterface getNextRoad(Car c);

	public void setNextRoad(CarDirectionInterface r);

    public double getRoadClosed();
    
}
