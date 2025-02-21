import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    public Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();
    int xCoord;
    int yCoord;


    Workshop<Volvo240> workshop = new Workshop<>(1);


    //methods:
    private void turnAround(Car car){
        car.stopEngine();
        car.turnRight();
        car.turnRight();
        car.startEngine();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int index = 0;
            for (Car car : cars) {
                System.out.println("car current speed: " + car.getCurrentSpeed());
                System.out.println("car x: " + car.getX());
                System.out.println("car y: " + car.getY());
                car.move();
                if (car.getY() < 0) {
                    car.setY(0);
                    turnAround(car);
                } else if (car.getY() > frame.drawPanel.getPreferredSize().height - 60) {
                    car.setY(frame.drawPanel.getPreferredSize().height - 60);
                    turnAround(car);
                }
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());

                if (car instanceof Volvo240 && car.getY() > 300) {
                    workshop.addCar((Volvo240) car);
                    car.setY(300);
                    car.setX(300);
                }

                frame.drawPanel.moveit(x, y, index);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
                index += 1;
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars
                ) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.brake(brake);
        }
    }

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

    void startEngine() {
        for (Car car : cars) {
            car.startEngine();
        }
    }

    void stopEngine() {
        for (Car car : cars) {
            car.stopEngine();
        }
    }
}
