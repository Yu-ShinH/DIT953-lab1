import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel implements ObserveTimeKeeper{

    List<DrawableCar> cars;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, List<DrawableCar> cars) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.cars = cars;

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        List<BufferedImage> images = getImages();
        List<Point> points = getPoints();
        super.paintComponent(g);
        for (int i = 0; i < images.size(); i++) {
            BufferedImage tmpImage = images.get(i);
            Point tmpPoint = points.get(i);
            g.drawImage(tmpImage, tmpPoint.x, tmpPoint.y, null); // see javadoc for more info on the parameters
        }
    }

    private List<BufferedImage> getImages() {
        List<BufferedImage> images = new ArrayList<>();
        for (DrawableCar c : cars) {
            images.add(c.getImage());
        }
        return images;
    }

    private List<Point> getPoints() {
        List<Point> points = new ArrayList<>();
        for (DrawableCar c : cars) {
            car car = c.getCar();
            int x = (int) car.getX();
            int y = (int) car.getY();
            points.add(new Point(x, y));
        }
        return points;
    }

    @Override
    public void update() {
        repaint();
    }
}
