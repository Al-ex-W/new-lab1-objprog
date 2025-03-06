import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;




public class CarController {

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    public Timer timer = new Timer(delay, new TimerListener());
    // The frame that represents this instance View of the MVC pattern
    CarView frame = new CarView("CarSim 1.0", this);
    Point workshopPoint = frame.drawPanel.volvoWorkshopPoint;
    Workshop<Volvo240> workshop = new Workshop<>(1);
    public CarChecker checker;
    double frameWidth;
    double frameHeight;
    int workshopCap = 1;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();
    int xCoord;
    int yCoord;

    void turnAround(Car car){
        //car.stopEngine();
        car.turnRight();
        car.startEngine();
    }

    void carIsCloseToEdge(Car car, Dirs dir){
        switch(dir) {
            case SOUTH:
                setCarY(car, (int) frameHeight);
                break;
            case  EAST:
                setCarX(car, (int) frameWidth);
                break;
            case NORTH:
                setCarY(car,0);
                break;
            case WEST:
                setCarX(car,0);
                break;
        }
        turnAround(car);
    }

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
                    index += 1;
                }
                frame.drawPanel.repaint();
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



    void addCar(Models_enum car) {

        if (cars.size() < 10) {
            System.out.println("inside cc addCar with car enum:");
            System.out.println(car);
            if(car == Models_enum.RANDOMCAR) {
                addCar(Models_enum.getRandomModel());
            } else {
                switch(car){
                    case VOLVO240:
                        cars.add(new Volvo240());
                        System.out.println("adding volvo car!");
                        break;
                    case SAAB95:
                        cars.add(new Saab95());
                        System.out.println("adding saab car!");
                        break;
                    case SCANIA:
                        cars.add(new Scania());
                        System.out.println("adding scania car!");
                        break;
                }
                frame.drawPanel.addModelToPanel(car);
            }
        }
    }

    void removeCar() {
        if (!cars.isEmpty()) {
            cars.remove(cars.size() - 1);
            frame.drawPanel.removeModelFromPanel();
        }
    }
}
