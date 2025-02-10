import java.awt.*;

public abstract class LoaderCar extends Car{

     // Definieras i TON
    private double trunkAngle;
    private int capacity;

    public LoaderCar(int drs, Color clr, double engPow, String modName, int cap) {
        super(drs, clr, engPow, modName);
        capacity = cap; // Definieras i TON
        trunkAngle = 0;
    }

    public void changeTrunkAngle(double amount) {

        if (amount < 0 || amount > 70) {
            throw new IllegalArgumentException("Angle must be between 0 and 70.");
            //ksk exception?
        } else if (getCurrentSpeed() != 0) {
            throw new IllegalArgumentException("Angle can only change at standstill.");
            //ksk exception?
        } else {
            setTrunkAngle(amount);
        }
    }

    public Integer getCapacity() {
        return capacity;
    }

    public double getTrunkAngle() {
        return trunkAngle;
    }

    public void setTrunkAngle(double amount) {trunkAngle = amount; }

    //vi behöver 2 til funktioner: lowerTrunkAngle och

    public abstract void lowerTrunkAngle();

    public abstract void raiseTrunkAngle();

    @Override
    public void move() {

        if (trunkAngle != 0) {
            //om trunk angel är höjt
            throw new IllegalArgumentException("Cannot move while trunk is raised.");
            //exception??
        } else {
            super.move();
        }
    }
    // använd super.gas()



}
