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


/*
   public void changeTrunkAngle(double position) {

      if (position == 0 && getCurrentSpeed() != 0) {
         throw new IllegalArgumentException("Transporter must be still when chnaging trunkangle");
         //ksk exception?
      }  else {
         setTrunkAngle(position);
      }
   } */
   public boolean carIsClose(Car carToLoad) {
      return ((Math.abs(this.getX() - carToLoad.getX()) <= 0.5) && (Math.abs(this.getY() - carToLoad.getY()) <= 0.5));
   }
   public void addCar(LoadableCar carToLoad) {
      if (getTrunkAngle() == LOWERED && carIsClose(carToLoad) && loadedCarList.size() < getCapacity()) {
         loadedCarList.add(carToLoad);
         carToLoad.setIsConnectedTo(this);
         //FIX ABOVE
      }else {
         throw new IllegalArgumentException("Cant load that car right now");
      }
   }

   public void releaseCar() {
      if (getTrunkAngle() == LOWERED && !loadedCarList.isEmpty()) {
         LoadableCar releasedCar = loadedCarList.get(loadedCarList.size()-1);
         //FIX CAST
         releasedCar.setIsConnectedTo(null);
         //SET TO NULL
         loadedCarList.remove(loadedCarList.size()-1);
         // sätt bilen nära transportern
         releasedCar.setX(this.getX());
         releasedCar.setY(this.getY());


      }else {
         throw new IllegalArgumentException("Cant release car right now");
      }
   }
   @Override
   public void lowerTrunkAngle() {
      changeTrunkAngle(LOWERED);
   }
   @Override
   public void raiseTrunkAngle() {changeTrunkAngle(RAISED);}

   //vi behöver 3 metoder: changetrunkangle, lowertrunk och raisetrunk

  /* @Override
   public void gas(double amount) {
      if (getTrunkAngle() == 0) {
         //om trunk angel är höjt
         System.out.println("cannot gas while trunk is lowered.");
         //exception??
      } else {
         super.gas(amount);
      }
   }*/

}
// Linca med scania lasbilen ska ha ett flak
    // i for m av en ramp