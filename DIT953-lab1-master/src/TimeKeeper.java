import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TimeKeeper {
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    List<ObserveTimeKeeper> observers = new ArrayList<>();

    public void addObserver(ObserveTimeKeeper observer) {
        observers.add(observer);
    }

    public void startTimer() {
        timer.start();
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (ObserveTimeKeeper o : observers) {
                o.update();
            }
        }
    }
}
