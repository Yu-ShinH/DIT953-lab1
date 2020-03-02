import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarModel implements ObserveTimeKeeper {
    // member fields:
    private List<DrawableCar> drawableCars;
    private List<car> cars;

    private int X;
    private int Y;

    //methods:

    public CarModel(List<DrawableCar> drawableCars, int X, int Y) {
        this.drawableCars = drawableCars;
        cars = getCars();
        initCars();
        this.X = X;
        this.Y = Y;
    }

    private List<car> getCars() {
        ArrayList<car> cars = new ArrayList<>();
        for (DrawableCar dc : drawableCars) {
            cars.add(dc.getCar());
        }
        return cars;
    }

    private void initCars() {
        for (int i = 0; i < cars.size(); i++) {
            car c = cars.get(i);
            c.setY(i * 100);
        }
    }

    public void addCar(DrawableCar dc) {

        try {
            if (drawableCars.size() >= 10) {
                throw new IllegalStateException();
            }
            drawableCars.add(dc);
            cars = getCars();
        } catch (IllegalStateException e) {
            System.out.println("List of cars is full.");
        }
        initCars();
    }

    public void removeCar() {

        try {
            if (drawableCars.isEmpty()) {
                throw new IllegalStateException();
            }
            drawableCars.remove(drawableCars.size() - 1);
        } catch (IllegalStateException e) {
            System.out.println("List of cars is empty.");
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (car c : cars) {
            c.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount / 100);
        for (car c : cars) {
            c.brake(brake);
        }
    }

    void turboOn() {
        for (car c : cars) {
            if (c instanceof Saab95){
                Saab95 s = (Saab95) c;
                s.setTurboOn();
            }
        }
    }

    void turboOff() {
        for (car c : cars) {
            if (c instanceof Saab95) {
                Saab95 s = (Saab95) c;
                s.setTurboOff();
            }
        }
    }

    void liftBed() {
        for (car c : cars) {
            if (c instanceof Scania) {
                Scania s = (Scania) c;
                s.raise(35);
            }
        }
    }

    void lowerBed() {
        for (car c : cars) {
            if (c instanceof Scania) {
                Scania s = (Scania) c;
                s.lower(35);
            }
        }
    }

    void startAll() {
        for (car c : cars) {
            c.startEngine();
        }
    }

    void stopAll() {
        for (car c : cars) {
            c.stopEngine();
        }
    }

    @Override
    public void update() {
        for (DrawableCar dc : drawableCars) {
            adjustDirection(dc);
            dc.getCar().move();
        }
    }

    private boolean checkCollision(DrawableCar drawable) {
        int width = drawable.getImage().getWidth();
        double xCoordinate = drawable.getCar().getX();

        if (xCoordinate + width >= X) {
            return true;
        }

        if (xCoordinate <= 0) {
            return true;

        }
        return false;
    }

    private void adjustDirection(DrawableCar drawable) {
        if (checkCollision(drawable)) {
            double currentDirection = drawable.getCar().getDirection();
            double newDirection = currentDirection + Math.PI;
            drawable.getCar().setDirection(newDirection);
        }
    }


}
