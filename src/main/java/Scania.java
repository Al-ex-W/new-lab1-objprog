import java.awt.*;

public class Scania extends LoaderCar{
    public Scania() {
        //Loader(int drs, Color clr, double engPow, String modName, double capacity)
        super(2, Color.pink, 1500, "Scania", 5);
    }

/*    public void changeTrunkAngle(double amount) {
        double newAngle = amount;

        if (newAngle < 0 || newAngle > 70) {
            throw new IllegalArgumentException("Angle must be between 0 and 70.");
            //ksk exception?
        } else if (getCurrentSpeed() != 0) {
            throw new IllegalArgumentException("Angle can only change at standstill.");
            //ksk exception?
        } else {
            setTrunkAngle(newAngle);
        }
    }

    public void lowerTrunkAngle(double amount) {
        double newAngle = getTrunkAngle() - amount;
        changeTrunkAngle(newAngle);
    }

    public void raiseTrunkAngle(double amount) {
        double newAngle = getTrunkAngle() + amount;
        changeTrunkAngle(newAngle);
    }

    @Override
    public void lowerTrunkAngle() {
        System.out.println("lowering trunk 10 degree...");
        lowerTrunkAngle(10);
    }

    @Override
    public void raiseTrunkAngle() {
        System.out.println("raising trunk 10 degree...");
        raiseTrunkAngle(10);

    }
}
