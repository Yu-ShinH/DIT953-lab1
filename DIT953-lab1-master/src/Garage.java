import java.util.ArrayList;
import java.util.List;

/**
 * Represents a garage.
 * @author Yu Shin Hua
 * @author Marja Rolandsson
 * @author Simon Genne
 */
public class Garage <C extends car>{
    private int maxCars;

    private List<C> cars = new ArrayList<C>();

    /**
     * Constructor for Garage objects.
     * @param maxCars the max amount of cars the garage can hold at one time.
     */
    public Garage(int maxCars) {
        this.maxCars = maxCars;
    }

    /**
     * Adds a given car to the garage.
     * @param c the car to be added to the garage.
     */
    public void addCar(C c){
       if(cars.size()<maxCars){
           cars.add(c);
       }
    }

    public int nCars() {
        return cars.size();
    }
}
