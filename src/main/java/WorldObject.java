public abstract class WorldObject {
    private double x;
    private double y;
    public WorldObject() {
        x = 0;
        y = 0;
    }

    public double getX() {
        return x;
    }


    public double getY() {
        return y;
    }

    public void setX(double val) {x = val;}
    public void setY(double val) {y = val;}

}
