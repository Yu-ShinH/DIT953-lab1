import java.awt.*;

/**
 * represents a Volvo240
 */

public class Volvo240 extends car{
    public final static double trimFactor = 1.25;

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
        return enginePower * 0.01 * trimFactor;
    }

    /**
     * Increases the speed of the car by a given amount.
     * @param amount specifies the amount with which to increase the speed.
     */
    public void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    /**
     * Decreases the speed of the car by a given amount.
     * @param amount specifies the amount with which to decrease the speed.
     */
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
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
