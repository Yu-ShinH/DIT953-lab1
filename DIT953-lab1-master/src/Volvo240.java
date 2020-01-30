import java.awt.*;

/**
 * Represents a Volvo 240
 * @author Yu Shin Hua
 * @author Marja Rolandsson
 * @author Simon Genne
 */
public class Volvo240 extends car{
    private final static double trimFactor = 1.25;

    /**
     * Constructor of Volvo240 objects.
     */
    public Volvo240(){
       super(4,Color.black,100,"Volvo240");
    }

    /**
     * @return the current speed factor of the car.
     */
    public double speedFactor(){
        return speedFactor(trimFactor);
    }

    /**
     * Increases the speed of the car by a given amount.
     * @param amount specifies the amount with which to increase the speed.
     */
    public void incrementSpeed(double amount){
        double newSpeed = calculateSpeed(speedFactor(), amount);
	    newSpeed = Math.min(newSpeed, getEnginePower());
        setCurrentSpeed(newSpeed);
    }

    /**
     * Decreases the speed of the car by a given amount.
     * @param amount specifies the amount with which to decrease the speed.
     */
    public void decrementSpeed(double amount){
        double newSpeed = calculateSpeed(speedFactor(), -amount);
        newSpeed = Math.max(newSpeed,0);
        setCurrentSpeed(newSpeed);
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}
