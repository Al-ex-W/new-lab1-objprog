import java.util.List;
import java.util.*;

public class Workshop<T extends Car> extends WorldObject {
    private Integer capacity;
    private final List<T> storedCarList = new ArrayList<>();
    public Workshop(int cap){
        super();
        capacity = cap;
    }

    public List<T> getStoredCarList() {
        return storedCarList;
    }

    public void addCar(T car) {
        if (!storedCarList.contains(car)) {
            if (storedCarList.size() < capacity) {
                    storedCarList.add(car);
                    car.store();
                    System.out.println(" Allowed to store");
            } else {
                System.out.println(" Storage is full");
            }
        }
    }
    public void releaseCar(T car) {
        if (storedCarList.contains(car)) {
            storedCarList.remove(car);
            car.unStore();

        } else {
            System.out.println("Car not here");
        }
    }

    public double getX() {
        return super.getX();
    }
    public double getY() {
        return super.getY();
    }

}
