import java.awt.*;

public abstract class LoadableCar extends Car {

    private LoaderCar isConnectedTo;
    public LoadableCar(int drs, Color clr, double engPow, String modName) {
        super(drs, clr, engPow, modName);
        isConnectedTo = null;
    }

    public LoaderCar getIsConnectedTo() {
        return isConnectedTo;
    }

    public void setIsConnectedTo(LoaderCar loader) {
        isConnectedTo = loader;
    }
    

    @Override
    public double getX(){
        if (isConnectedTo != null) {
            return isConnectedTo.getX();
        } else {
            return super.getX();
        }
    }

    @Override
    public double getY(){
        if (isConnectedTo != null) {
            return isConnectedTo.getY();
        } else {
            return super.getY();
        }
    }

}
