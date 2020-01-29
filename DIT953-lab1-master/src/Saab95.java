import java.awt.*;

/**
 * Represents a Saab95
 */

public class Saab95 extends car{
    public boolean turboOn;

    /**
     * Constructor for Saab95 objects.
     */
    public Saab95() {
        super(2,Color.red,125,"Saab95");
        turboOn = false;
    }

    /**
     * Turns turbo on.
     */
    public void setTurboOn(){
	    turboOn = true;
    }

    /**
     * Turns turbo off.
     */
    public void setTurboOff(){
	    turboOn = false;
    }

    /**
     * @return the current speed factor of the car.
     */
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    /**
     * Increases the speed of the car by a given amount.
     * @param amount specifies the amount with which to increase the speed.
     */
    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    /**
     * Decreases the speed of the car by a given amount.
     * @param amount specifies the amount with which to decrease the speed.
     */
    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
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
