import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarChecker {
    CarController cc;
    public  CarChecker (CarController cc) {
       this.cc = cc;
    }

    public void check(Car car) {
        if (car.getY() < 0) {
            cc.carIsCloseToEdge(car, Dirs.NORTH);
        } else if (car.getX() < 0) {
            cc.carIsCloseToEdge(car, Dirs.WEST);
        } else if (car.getY() > cc.frameHeight) {
            cc.carIsCloseToEdge(car, Dirs.SOUTH);
        } else if (car.getX() > cc.frameWidth) {
            cc.carIsCloseToEdge(car, Dirs.EAST);
        }

        if (car instanceof Volvo240 && car.getY() > 300) {
            cc.addToWorkshop(car);
        }
    }


}
