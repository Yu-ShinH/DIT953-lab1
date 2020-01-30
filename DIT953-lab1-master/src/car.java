import java.awt.*;

/**
 * Represents a car
 * @author Yu Shin Hua
 * @author Marja Rolandsson
 * @author Simon Genne
  */
public abstract class car implements Movable{

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double x = 0;
    private double y = 0;
    private double direction = 0;
    private double turnAngle = 45;

    /**
     * Constructor for subclasses of car.
     * @param nrDoors specifies the number of doors of the car.
     * @param color specifies the color of the car.
     * @param enginePower specifies the engine power of the car.
     * @param modelName specifies the model name of the car.
     */
    public car(int nrDoors, Color color, double enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
    }

    /**
     * Changes the position of the car.
     */
    public void move() {
        double dx = Math.cos(getDirection())*getCurrentSpeed();
        double dy = Math.sin(getDirection())*getCurrentSpeed();
        x = getX() + dx;
        y = getY() + dy;
    }

    /**
     * Changes the direction of the car by 45 degrees in the positive direction.
     */
    public void turnLeft() {
        setDirection(getDirection() + turnAngle);
        if(getDirection() >= 360)
        {
            setDirection(0) ;
        }
    }

    /**
     * Changes the direction of the car by 45 degrees in the negative direction.
     */
    public void turnRight() {
        setDirection(getDirection() - turnAngle);
        if(getDirection() <= -360)
        {
            setDirection(0) ;
        }
    }

    /**
     * Changes the direction of the car.
     * @param direction specifies the direction.
     */
    public void setDirection(double direction){
        this.direction = direction % 360;
    }

    /**
     * @return the current direction of the car.
     */
    public double getDirection()
    {
        return direction;
    }

    /**
     * Changes the x-coordinate of the car.
     * @param x specifies the x-coordinate.
     */
    public void setX(double x){
        this.x = x;
    }

    /**
     * Changes the y-coordinate of the car.
     * @param y specifies the y-coordinate.
     */
    public void setY(double y){
        this.y = y;
    }

    /**
     * @return the current x-coordinate of the car.
     */
    public double getX(){
        return x;
    }

    /**
     * @return the current y-coordinate of the car.
     */
    public  double getY(){
        return  y;
    }

    /**
     * @return the number of doors on the car.
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     *
     * @return the cars enginge power.
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * @return the current speed of the car.
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * Changes the current speed of the car.
     * @param speed specifies the new speed.
     */
    public void setCurrentSpeed(double speed) {
        this.currentSpeed = speed;
    }

    /**
     * @return the color of the car.
     */
    public Color getColor(){
        return color;
    }

    /**
     * Changes the color of the car.
     * @param clr specifies the color.
     */
    public void setColor(Color clr){
        color = clr;
    }

    /**
     * Sets the current speed of the car to 0.1.
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Sets the speed of the car to 0.
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * @param factor individual factor from sub classes.
     * @return the current speed factor of the car.
     */
    public double speedFactor(double factor) {
        return enginePower * 0.01 * factor;
    }

    /**
     * Calculates the new speed of the car given a speed factor and an amount.
     * @param factor speed factor.
     * @param amount amount to change the speed with.
     * @return calculated new speed
     */
    public double calculateSpeed(double factor, double amount) {
        return currentSpeed + factor * amount;
    }
}
