import java.util.ArrayList;

public class Ferry implements Movable {
    private boolean rampIsUp = true;
    private double enginePower;
    private Transporter<IFerryTransportable> transporter;
    private Mover mover = new Mover();
    private double maxWeight;


    public Ferry(int maxCapacity, double enginePower, double maxWeight) {
        transporter = new Transporter<>(new ArrayList<IFerryTransportable>(), maxCapacity, mover);
        this.enginePower = enginePower;
        this.maxWeight = maxWeight;
    }

    public void load(car c) {
        if (isLoadable(c)) {
            transporter.load(c);
        }
    }

    private boolean isLoadable(car c) {
        if (!(c instanceof  IFerryTransportable))
        if (c.getWeigth() > maxWeight) return false;
        if (rampIsUp) return false;
        if (c.distanceFrom(this) > 2) return false;
        return true;
    }

    public IFerryTransportable unload() {
        return transporter.unload();
    }

    public void raise() {
        rampIsUp = true;
    }

    public void lower() {
        if (getCurrentSpeed() == 0) {
            rampIsUp = false;
        }
    }

    public int nTransported() {
        return transporter.getN();
    }

    public void gas(double amount) {
        if (rampIsUp && amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        }
    }

    private void incrementSpeed(double amount) {
        double newSpeed = mover.getCurrentSpeed() + amount;
        newSpeed = Math.min(newSpeed, enginePower);
        setCurrentSpeed(newSpeed);
    }

    public void brake(double amount) {
        decrementSpeed(amount);
    }

    private void decrementSpeed(double amount) {
        double newSpeed = mover.getCurrentSpeed() - amount;
        newSpeed = Math.max(newSpeed, 0);
        setCurrentSpeed(newSpeed);
    }

    public void stopEngine() {
        mover.setCurrentSpeed(0);
    }

    private void setCurrentSpeed(double speed) {
        mover.setCurrentSpeed(speed);
    }

    public double getCurrentSpeed() {
        return mover.getCurrentSpeed();
    }

    public void setDirection(double direction) {
        mover.setDirection(direction);
    }

    public double getDirection() {
        return mover.getDirection();
    }

    public double getX() {
        return mover.getX();
    }

    public double getY() {
        return mover.getY();
    }

    public void setX(double x) {
        mover.setX(x);
    }

    public void setY(double y) {
        mover.setY(y);
    }

    public void turnRight() {
        mover.turnRight();
    }

    public void turnLeft() {
        mover.turnLeft();
    }

    public void move() {
        transporter.move();
    }
}
