import java.awt.*;

public class Volvo240 extends LoadableCar{

    private final static double trimFactor = 1.25;
    
    public Volvo240(){
        super(4,Color.black,100,"Volvo240");
        setX(350);
    }

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}
