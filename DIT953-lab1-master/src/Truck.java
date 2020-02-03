import java.awt.*;
import java.util.Stack;

public class Truck extends car{
    boolean rampIsUp = true;
    Stack<car> cars = new Stack<car>();

    public Truck() {
        super(2, Color.red,100, "Truck");
    }

    public void load(car c){

        if(c.getWeigth()<1500&&cars.size()<10&&!rampIsUp&&distanceFrom(c)<2&&c!=this)
        {
            cars.push(c);
        }
    }

    public void unLoad(){
        if(!rampIsUp)
        {
            car c = cars.pop();
            c.setX(getX()+1);
            c.setY(getY()+1);
        }

    }

    public void raise()
    {
        rampIsUp = true;
    }
    public void lower(){
        if(getCurrentSpeed()== 0){
            rampIsUp = false;
        }
    }

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

    @Override
    public void gas(double amount) {
        gas(1,amount);

    }

    @Override
    public void brake(double amount) {
        brake(1,amount);
    }
}
