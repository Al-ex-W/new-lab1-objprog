import java.awt.*;
import java.lang.Math;
import java.util.*;
import java.util.List;

public class Transporter extends LoaderCar {
   public static final double LOWERED = 1;
   public static final double RAISED = 0;
   private final List<LoadableCar> loadedCarList = new ArrayList<>();

   public Transporter() {
      super(2, Color.black, 1200, "Roger The Transporter", 2);

   }
   public boolean carIsClose(Car carToLoad) {
      return ((Math.abs(this.getX() - carToLoad.getX()) <= 0.5) && (Math.abs(this.getY() - carToLoad.getY()) <= 0.5));
   }
   public void addCar(LoadableCar carToLoad) {
      if (trunk.getTrunkAngle() == LOWERED && carIsClose(carToLoad) && loadedCarList.size() < trunk.getCapacity()) {
         loadedCarList.add(carToLoad);
      }else {
         throw new IllegalArgumentException("Cant load that car right now");
      }
   }

   public void releaseCar() {
      if (trunk.getTrunkAngle() == LOWERED && !loadedCarList.isEmpty()) {
         LoadableCar releasedCar = loadedCarList.get(loadedCarList.size()-1);
         loadedCarList.remove(loadedCarList.size()-1);
         releasedCar.setX(this.getX());
         releasedCar.setY(this.getY());


      }else {
         throw new IllegalArgumentException("Cant release car right now");
      }
   }
   public void lowerTrunkAngle() {
      changeTrunkAngle(LOWERED);
   }

   public void raiseTrunkAngle() {changeTrunkAngle(RAISED);}

   @Override
   public void move() {

      if (trunk.getTrunkAngle() != 0) {
         throw new IllegalArgumentException("Cannot move while trunk is raised.");
      } else {
         super.move();
         for (LoadableCar car : loadedCarList) {
            car.setX(this.getX());
            car.setY(this.getY());
         }
      }
   }

}
