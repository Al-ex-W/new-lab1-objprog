import java.awt.*;

public class Scania extends LoaderCar{
    public Scania() {
        super(2, Color.pink, 1500, "Scania", 5);
        setX(250);
    }


    public void lowerTrunkAngle(double amount) {
        double newAngle = trunk.getTrunkAngle() - amount;
        changeTrunkAngle(newAngle);
    }

    public void raiseTrunkAngle(double amount) {
        double newAngle = trunk.getTrunkAngle() + amount;
        changeTrunkAngle(newAngle);
    }

}
