import java.util.List;

public class Transporter<T> {
    private double currentSpeed;
    private double x = 0;
    private double y = 0;
    private double direction = 0;
    private double turnAngle = Math.PI/4;
    private double weight;

    private List<T> load;

    public Transporter(double currentSpeed, double x, double y, double weight, List<T> load) {
        this.currentSpeed = currentSpeed;
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.load = load;
    }

    public void move() {
        double dx = Math.cos(getDirection())*getCurrentSpeed();
        double dy = Math.sin(getDirection())*getCurrentSpeed();
        x = getX() + dx;
        y = getY() + dy;
    }

    public void turnLeft() {
        setDirection(getDirection() + turnAngle);
        if(getDirection() >= -2 * Math.PI)
        {
            setDirection(0) ;
        }
    }

    public void turnRight() {
        setDirection(getDirection() - turnAngle);
        if(getDirection() <= -2 * Math.PI)
        {
            setDirection(0) ;
        }
    }

    private void setDirection(double direction) {
        this.direction = direction;
    }

    public double getDirection() {
        return direction;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    private void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }


}
