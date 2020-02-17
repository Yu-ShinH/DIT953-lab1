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

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<car> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());

        initCars(cc.cars);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    private static void initCars(List<car> list) {
        for (int i = 0; i < list.size(); i++) {
            car c = list.get(i);
            c.setY(i * 100);
        }
    }


    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < cars.size(); i++) {
                car c = cars.get(i);
                c.move();
                int x = (int) Math.round(c.getX());
                int y = (int) Math.round(c.getY());
                frame.drawPanel.moveit(i, x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    /*
    public boolean checkCollision(int x) {
        return (x < 0 || x + )
    }

     */

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (car c : cars) {
            c.gas(gas);
            System.out.println(c.getCurrentSpeed());
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
                System.out.println("turbo " + s.isTurboOn());
                System.out.println("speed: " + s.getCurrentSpeed());
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
