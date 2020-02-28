import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeKeeper {
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    CarModel model;
    DrawPanel panel;


    public TimeKeeper(CarModel model, DrawPanel panel) {
        this.model = model;
        this.panel = panel;

        timer.start();
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.updateCars();
            panel.repaint();
        }
    }
}
