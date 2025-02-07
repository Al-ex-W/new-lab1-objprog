import java.awt.*;

public class Scania extends Car{

    private double torque;
    private double trunkAngle;

    public Scania() {
        super(2, Color.pink, 125, "Scania");
        torque = 950;
        trunkAngle = 0;
    }

    public double getTrunkAngle() {
        return trunkAngle;
    }

    public void setTrunkAngle(double amount)    {
        double newAngle = amount;

        if(newAngle < 0 || newAngle > 70)   {
            System.out.println("Angle must be between 0 and 70.");
            //ksk exception?
        } else if(getCurrentSpeed()!=0) {
            System.out.println("Angle can only be changed at standstill.");
            //ksk exception?
        } else {
            trunkAngle = newAngle;
        }
    }

    //vi behöver 2 til funktioner: lowerTrunkAngle och 

    public double lowerTrunkAngle(double amount) {
        double newAngle = getTrunkAngle() - amount;
        return(newAngle);
    }

    public double raiseTrunkAngle(double amount) {
        double newAngle = getTrunkAngle() + amount;
        return(newAngle);
    }
    
    @Override
    public void gas(double amount) {
        
        if (trunkAngle != 0) {
            //om trunk angel är höjt
            System.out.println("cannot gas while trunk is raised.");
            //exception??
        } else {
            super.gas(amount);
        }
    }
    // använd super.gas()

   

}
