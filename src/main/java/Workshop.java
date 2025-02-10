import java.util.List;
import java.util.*;

public class Workshop<T extends Car>{
    private Integer capacity;
    private final List<T> storedCarList = new ArrayList<>();
    public Workshop(int cap){
        capacity = cap;
    }

    public void addCar(T car) {
        if (storedCarList.size() < capacity) {
            storedCarList.add(car);
            System.out.println(" Alloed to Sotre");
        }else {
            System.out.println(" Storage is full");

        }
    }
    public void releaseCar(T car) {
        if (storedCarList.contains(car)) {
            storedCarList.remove(car);

        } else {
            System.out.println("Car not here");
        }
    }

}
