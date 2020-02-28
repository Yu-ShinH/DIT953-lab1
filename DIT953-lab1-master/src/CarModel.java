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

public class CarModel {
    // member fields:

    // The frame that represents this instance View of the MVC pattern
    // A list of cars, modify if needed
    private List<DrawableCar> drawableCars;
    private List<car> cars;

    //methods:

    public CarModel(List<DrawableCar> drawableCars) {
        this.drawableCars = drawableCars;
        cars = getCars();
    }

    private List<car> getCars() {
        ArrayList<car> cars = new ArrayList<>();
        for (DrawableCar dc : drawableCars) {
            cars.add(dc.getCar());
        }
        return cars;
    }

    private static void initCars(List<car> list) {
        for (int i = 0; i < list.size(); i++) {
            car c = list.get(i);
            c.setY(i * 100);
        }
    }



    /*
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < cars.size(); i++) {

                car c = cars.get(i);
                c.move();

                int x = (int) Math.round(c.getX());
                int y = (int) Math.round(c.getY());

                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();



            }
        }
    }

    */


    public void updateCars() {
        for (car c : cars) {
            c.move();
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
}
