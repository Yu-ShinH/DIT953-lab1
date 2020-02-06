import java.awt.*;

/**
 * Represents a Saab 9-5.
 * @author Yu Shin Hua
 * @author Marja Rolandsson
 * @author Simon Genne
 */
public class Saab95 extends car implements ITruckTransportable{
    private boolean turboOn;

    /**
     * Constructor for Saab95 objects.
     */
    public Saab95() {
        super(2,Color.red,125,"Saab95", 1000);
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
     *
     * @param amount
     */
    @Override
    public void gas(double amount){
        gas(speedFactor(), amount);
    }

    @Override
    public void brake(double amount){
        brake(speedFactor(), amount);
    }
}
