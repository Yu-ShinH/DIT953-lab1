import java.util.ArrayList;
import java.util.List;

public class Garage <C extends car>{
    private int maxCars;

    List<C> cars = new ArrayList<C>();
    public void addCar(C c){
       if(cars.size()<maxCars){
           cars.add(c);
       }
    }
}
