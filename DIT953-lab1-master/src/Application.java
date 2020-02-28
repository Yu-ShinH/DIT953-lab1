import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int X = 700; //800
    private static final int Y = 700; //800

    public static void main(String[] args) {
        List<DrawableCar> drawableCars = createList();

        CarModel cm = new CarModel(drawableCars);
        CarController cc = new CarController(cm);
        DrawPanel dp = new DrawPanel(X, Y - 240, drawableCars);
        CarView cv = new CarView("CarSim 1.0", cc, dp, X, Y);

        TimeKeeper timer = new TimeKeeper();
        timer.addObserver(cm);
        timer.addObserver(dp);
        timer.startTimer();


        /*
        List<DrawableCar> cars = new ArrayList<>();


        DrawPanel panel = new DrawPanel(X, Y - 240, cars);
        CarModel cm = new CarModel(new CarView("CarSim 1.0", new CarController()));

        cm.cars.add(new Volvo240());
        cm.cars.add(new Saab95());
        cm.cars.add(new Scania());

        // Start a new view and send a reference of self
        cm.frame = new CarView("CarSim 1.0", new CarController(cm), panel, X, Y);


        // Start the timer
        cm.startTimer();

         */
    }

    private static List<DrawableCar> createList() {
        List<DrawableCar> list = new ArrayList<>();
        car volvo = new Volvo240();
        car saab = new Saab95();
        car scania = new Scania();

        BufferedImage volvoPic;
        BufferedImage saabPic;
        BufferedImage scaniaPic;

        try {
            volvoPic = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabPic = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaPic = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));

            list.add(new DrawableCar(volvo, volvoPic));
            list.add(new DrawableCar(saab, saabPic));
            list.add(new DrawableCar(scania, scaniaPic));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
        return list;
    }
}
