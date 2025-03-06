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

        if (cc.workshop.getStoredCarList().size() < cc.workshopCap  && car instanceof Volvo240 && (cc.workshopPoint.y < car.getY() && car.getY() < (cc.workshopPoint.y + 100)) && (cc.workshopPoint.x < car.getX() && car.getX() < (cc.workshopPoint.x + 100))) {
            cc.addToWorkshop(car);
        }
    }


}
