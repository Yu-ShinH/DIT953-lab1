import java.awt.*;
import java.util.Stack;

/**
 * Represents a truck used for transporting cars.
 * @author Yu Shin Hua
 * @author Marja Rolandsson
 * @author Simon Genne
 */
public class Truck extends car{
    boolean rampIsUp = true;
    private Stack<car> cars = new Stack<car>();

    /**
     * Constructor for Truck objects.
     */
    public Truck() {
        super(2, Color.red,100, "Truck", 15000);
    }

    /**
     * Loads a car onto the truck.
     * A car can only be loaded if its weight is not above 1500 kg, the ramp of the truck is down, the car is within
     * 2 length units from the truck, and the given car is not the truck itself. The truck can hold a maximum of 10 cars
     * at one time.
     * @param c the car to be loaded onto the truck.
     */
    public void load(car c){
        if(isLoadable(c))
        {
            cars.push(c);
        }
    }

    /**
     * Checks if a given car can be loaded onto truck at current moment.
     * @param c the car to be loaded.
     * @return true if the car can be loaded, else false.
     */
    private boolean isLoadable(car c) {
        if (c.getWeigth() > 1500) return false;
        if (cars.size() > 10) return false;
        if (rampIsUp) return false;
        if (distanceFrom(c) > 2) return false;
        if (c == this) return false;
        return true;
    }

    /**
     * Unloads a single car from the truck.
     * Can only be done if the ramp is lowered.
     */
    public void unLoad(){
        if(!rampIsUp)
        {
            car c = cars.pop();
            c.setX(getX()+1);
            c.setY(getY()+1);
        }

    }

    /**
     * Raises the ramp of the truck.
     */
    public void raise()
    {
        rampIsUp = true;
    }

    /**
     * Lowers the ramp of the truck.
     * Can only be done if the truck is not moving.
     */
    public void lower(){
        if(getCurrentSpeed()== 0){
            rampIsUp = false;
        }
    }

    /**
     * Changes the position of the truck and all cars currently being transported.
     */
    @Override
    public void move() {
        super.move();
        double newX = getX();
        double newY = getY();
        for (car c :cars){
            c.setX(newX);
            c.setY(newY);
        }
    }

    /**
     * Increases the speed of the
     * @param amount specifies the amount with which to increase speed.
     */
    @Override
    public void gas(double amount) {
        if(!rampIsUp) {
            super.gas(1);
        }
        else {
            System.out.println("Cannot increase speed while ramp is up.");
        }
    }

}
