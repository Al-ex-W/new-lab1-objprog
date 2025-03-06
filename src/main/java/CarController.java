import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



public class CarController {

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    public Timer timer = new Timer(delay, new TimerListener());
    public CarChecker checker;
    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();
    int xCoord;
    int yCoord;

    void turnAround(Car car){
        car.stopEngine();
        car.turnRight();
        car.turnRight();
        car.startEngine();
    }

    Workshop<Volvo240> workshop = new Workshop<>(1);

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int index = 0;
                for (Car car : cars) {
                    System.out.println("running car move loop for");
                    System.out.println(car);
                    car.move();
                    checker.check(car);
                    int x = (int) Math.round(car.getX());
                    int y = (int) Math.round(car.getY());
                    frame.drawPanel.moveit(x, y, index);
                    // repaint() calls the paintComponent method of the panel
                    // ha kvar  frame.drawPanel.repaint();
                    frame.drawPanel.repaint();
                    index += 1;
                }
        }
    }

    void setCarX(Car car,int x) {
        car.setX(x);
    }

    void setCarY(Car car,int Y) {
        car.setY(Y);
    }

    void addToWorkshop(Car car) {
        workshop.addCar((Volvo240) car);
        car.setY(300);
        car.setX(300);
    }

    //byt Pltas till "Car Facade"
    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars
                ) {
            car.gas(gas);
        }
    }
    //byt Pltas till "Car Facade"

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.brake(brake);
        }
    }
    //byt Pltas till "Car Facade"

    void setTurbo(boolean val) {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                if (val) {
                    ((Saab95) car).setTurboOn();
                }
                else {
                    ((Saab95) car).setTurboOff();
                }
            }
        }
    }
    //byt Pltas till "Car Facade"

    void liftBed(boolean val) {
        for (Car car : cars) {
            if (car instanceof Scania) {
                if (val) {
                    ((Scania) car).raiseTrunkAngle(70);
                }
                else {
                    ((Scania) car).lowerTrunkAngle(70);
                }
            }
        }
    }
    //byt Pltas till "Car Facade"

    void startEngine() {
        for (Car car : cars) {
            car.startEngine();
        }
    }
    //byt Pltas till "Car Facade"

    void stopEngine() {
        for (Car car : cars) {
            car.stopEngine();
        }
    }
}
