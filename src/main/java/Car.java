import java.awt.*;

public abstract class Car implements Movable{
    private int nrDoors;
    private double enginePower;
    private double currentSpeed;
    private Color color;
    private String modelName;
    private int dirIndex;
    private double x;
    private double y;

    public Car(int drs, Color clr, double engPow, String modName){
        nrDoors = drs;
        color = clr;
        enginePower = engPow;
        modelName = modName;
        dirIndex = 0;
        x = 0;
        y = 0;
        stopEngine();
    }

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    @Override
    public void turnLeft(){
        dirIndex = (dirIndex + 3) % 4;
    }

    @Override
    public void turnRight(){
        dirIndex = (dirIndex + 1) % 4;
    }

    @Override
    public void move(){
        switch(dirIndex){
            case 0:
                y += currentSpeed;
                break;
            case 1:
                x += currentSpeed;
                break;
            case 2:
                y -= currentSpeed;
                break;
            case 3:
                x -= currentSpeed;
                break;
        }
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void setX(double val){
        x = val;
    }


    public void setY(double val){
        y = val;
    }

    public double speedFactor(){
        return getEnginePower() * 0.01;
    }


    public void gas(double amount){
        if (amount < 0 || amount > 1){
            throw new IllegalArgumentException("Gas amount must be between 0 and 1");
        }
        incrementSpeed(amount);
    }

    public void brake(double amount){
        if (amount < 0 || amount > 1){
            throw new IllegalArgumentException("Brake amount must be between 0 and 1");
        } else {
            decrementSpeed(amount);
        }
    }

    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

}
