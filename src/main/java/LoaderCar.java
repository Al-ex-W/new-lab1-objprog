import java.awt.*;

public abstract class LoaderCar extends Car{

    Trunk trunk;
    public LoaderCar(int drs, Color clr, double engPow, String modName, int cap) {
        super(drs, clr, engPow, modName);
        trunk  = new Trunk(0,cap);
    }

    public void changeTrunkAngle(double amount) {

        if (amount < 0 || amount > 70) {
            throw new IllegalArgumentException("Angle must be between 0 and 70.");
        } else if (getCurrentSpeed() != 0) {
            throw new IllegalArgumentException("Angle can only change at standstill.");
        } else {
            trunk.setTrunkAngle(amount);
        }
    }

    public double getTrunkAngle() {
        return trunk.getTrunkAngle();
    }

    @Override
    public void move() {

        if (trunk.getTrunkAngle() != 0) {
            throw new IllegalArgumentException("Cannot move while trunk is raised.");
        } else {
            super.move();
        }
    }



}
