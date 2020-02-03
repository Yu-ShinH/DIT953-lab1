import java.awt.*;

/**
 * Represents a Scania
 * @author Yu Shin Hua
 * @author Marja Rolandsson
 * @author Simon Genne
 */
public class Scania extends car{
    private double flatbed = 0;
    /**
     * Constructor of Scania objects.
     */
    public Scania() {
        super(2,Color.red,100, "Scania");
    }

    public void raise(double amount){
        if(getCurrentSpeed()!=0)
        {
            System.out.println("Cannot raise flatbed while moving");
            return;
        }
        flatbed += amount;
        if(flatbed>70)
        {
            flatbed = 70;
            System.out.println("Max angle reached");
        }
    }

    public void lower(double amount){
        flatbed -= amount;
        if(flatbed<0)
        {
            flatbed = 0;
            System.out.println("Min angle reached");
        }
    }

    public double getAngle(){
        return flatbed;
    }
    @Override
    public void move(){
        if(getAngle()!=0){
            System.out.println("Cannot move while flatbed is raised");
            return;
        }
        super.move();
    }
    @Override
    public void gas(double amount) {
        gas(1,amount);

    }

    @Override
    public void brake(double amount) {
        brake(1,amount);
    }
}
