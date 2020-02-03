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
    private double turnAngle = Math.PI/4;
    private double weight;

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
        if(getDirection() >= 2 * Math.PI)
        {
            setDirection(0) ;
        }
    }

    /**
     * Changes the direction of the car by 45 degrees in the negative direction.
     */
    public void turnRight() {
        setDirection(getDirection() - turnAngle);
        if(getDirection() <= -2 * Math.PI)
        {
            setDirection(0) ;
        }
    }

    /**
     * Changes the direction of the car.
     * @param direction specifies the direction.
     */
    public void setDirection(double direction){
        this.direction = direction;
    }

    /**
     * @return the current direction of the car.
     */
    public double getDirection()
    {
        return direction;
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

    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }
    /**
     * @return the number of doors on the car.
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
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
    private void setCurrentSpeed(double speed) {
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

    public double getWeigth(){
        return weight;
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
     * Increments the speed of the car.
     * @param factor speed factor of car.
     * @param amount amount to increase speed with.
     */
    private void incrementSpeed(double factor, double amount) {
        double newSpeed = currentSpeed + factor * amount;
        newSpeed = Math.min(newSpeed, enginePower);
        setCurrentSpeed(newSpeed);
    }

    /**
     * Decrements the speed of the car.
     * @param factor speed factor of car.
     * @param amount amount to decrease speed with.
     */
    private void decrementSpeed(double factor, double amount){
        double newSpeed = currentSpeed + factor * -amount;
        newSpeed = Math.max(newSpeed, 0);
        setCurrentSpeed(newSpeed);
    }

    /**
     * Accelerates car.
     * @param factor speed factor.
     * @param amount amount to increase speed with.
     */
    public void gas(double factor, double amount) {
        if(!(amount < 0) && !(amount > 1)) {
            incrementSpeed(factor, amount);
        }
    }
    /**
     * Deaccelerates car
     * @param factor speed factor.
     * @param amount amount to decrease speed with.
     */
    public void brake(double factor, double amount) {
        if (!(amount < 0) && !(amount > 1)) {
            decrementSpeed(factor, amount);
        }
    }
    public double distanceFrom(car c)
    {
        double x1 = getX();
        double y1 = getY();
        double x2 = c.getX();
        double y2 = c.getY();

        double deltaX = x2 - x2;
        double deltaY = y2 - y1;
        double distance = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        return distance;
    }

    public abstract void gas(double amount);
    public abstract void brake(double amount);
}
