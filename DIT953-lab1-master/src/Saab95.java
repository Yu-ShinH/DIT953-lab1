import java.awt.*;

/**
 * Represents a Saab 9-5
 * @author Yu Shin Hua
 * @author Marja Rolandsson
 * @author Simon Genne
 */
public class Saab95 extends car{
    private boolean turboOn;

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
        return speedFactor(turbo);
    }

    /**
     * Increases the speed of the car by a given amount.
     * @param amount specifies the amount with which to increase the speed.
     */
    public void incrementSpeed(double amount){
    double newSpeed = calculateSpeed(speedFactor(), amount);
    setCurrentSpeed(newSpeed);
    }

    /**
     * Decreases the speed of the car by a given amount.
     * @param amount specifies the amount with which to decrease the speed.
     */
    public void decrementSpeed(double amount){
        double newSpeed = calculateSpeed(speedFactor(), -amount);
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
