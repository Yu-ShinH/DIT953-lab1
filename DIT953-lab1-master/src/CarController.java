public class CarController {
    private CarModel model;

    public CarController(CarModel model) {
        this.model = model;
    }

    public void gas(int amount) {
        model.gas(amount);
    }

    public void brake(int amount) {
        model.brake(amount);
    }

    public void turboOn() {
        model.turboOn();
    }

    public void turboOff() {
        model.turboOff();
    }

    public void liftBed() {
        model.liftBed();
    }

    public void lowerBed() {
        model.lowerBed();
    }

    public void startAll() {
        model.startAll();
    }

    public void stopAll() {
        model.stopAll();
    }

    public void addCar(DrawableCar dc) {
        model.addCar(dc);
    }

    public void removeCar() {
        model.removeCar();
    }



}
