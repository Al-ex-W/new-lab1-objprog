public class Trunk {
    private double trunkAngle;
    private final int capacity;
    public Trunk(double angle, int cap){
        capacity = cap;
        trunkAngle = angle;
    }
    public Integer getCapacity() {
        return capacity;
    }
    public double getTrunkAngle() {
        return trunkAngle;
    }

    public void setTrunkAngle(double amount) {
        trunkAngle = amount;
    }

}
