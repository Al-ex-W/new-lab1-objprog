import org.junit.jupiter.api.Test;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    @Test
    public void Testdoors() {
        Saab95 saab = new Saab95();
        assertEquals(2, saab.getNrDoors());
    }

    @Test
    public void TestSetColor() {
        Saab95 saab = new Saab95();
        saab.setColor(Color.blue);
        assertEquals(Color.blue, saab.getColor());
    }

    @Test
    public void TestStartStopEngine() {
        Saab95 saab = new Saab95();
        saab.startEngine();
        assertEquals(0.1, saab.getCurrentSpeed(), 0.001);
        saab.stopEngine();
        assertEquals(0, saab.getCurrentSpeed(), 0.001);
    }

    @Test
    public void TestSaabGasBrake() {
        Saab95 saab = new Saab95();
        saab.startEngine();
        saab.setTurboOn();
        saab.gas(0.7);
        assertEquals((0.1 + (1.3 * 0.01 * 125) * 0.7), saab.getCurrentSpeed(), 0.001);
        saab.brake(0.3);
        assertEquals(((0.1 + (1.3 * 0.01 * 125) * 0.7) - (1.3 * 0.01 * 125 * 0.3)), saab.getCurrentSpeed(), 0.001);
    }

    @Test
    public void TestMove() {
        Saab95 saab = new Saab95();
        saab.startEngine();
        saab.setTurboOn();
        saab.gas(0.4);
        saab.move();
        double addedSpeed = saab.getCurrentSpeed();
        assertEquals(0, saab.getX(), 0.001);
        assertEquals(addedSpeed, saab.getY(), 0.001);
        saab.turnRight();
        saab.move();
        assertEquals(addedSpeed, saab.getX(), 0.001);
        assertEquals(addedSpeed, saab.getY(), 0.001);
        saab.turnRight();
        saab.move();
        assertEquals(addedSpeed, saab.getX(), 0.001);
        assertEquals(0, saab.getY(), 0.01);
        saab.turnRight();
        saab.move();
        assertEquals(0, saab.getX(), 0.001);
        assertEquals(0, saab.getY(), 0.001);
    }

    @Test
    public void TestVolvoGasBrake() {
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        volvo.gas(0.3);
        assertEquals((0.1 + (1.25 * 0.01 * 100) * 0.3), volvo.getCurrentSpeed(), 0.001);
        volvo.brake(0.04);
        assertEquals(((0.1 + (1.25 * 0.01 * 100) * 0.3) - (1.25 * 0.01 * 100 * 0.04)), volvo.getCurrentSpeed(), 0.001);
    }

    @Test
    public void Testgasbrakeinterval() {
        Volvo240 volvo = new Volvo240();
        Saab95 saab = new Saab95();
        volvo.startEngine();
        saab.startEngine();
        assertThrows(IllegalArgumentException.class, () -> volvo.gas(-1.1));
        assertThrows(IllegalArgumentException.class, () -> volvo.gas(1.1));
        assertThrows(IllegalArgumentException.class, () -> volvo.brake(-1.1));
        assertThrows(IllegalArgumentException.class, () -> volvo.brake(1.1));
        assertThrows(IllegalArgumentException.class, () -> saab.brake(1.1));
        assertThrows(IllegalArgumentException.class, () -> saab.brake(-1.1));
        assertThrows(IllegalArgumentException.class, () -> saab.gas(1.1));
        assertThrows(IllegalArgumentException.class, () -> saab.gas(-1.1));

    }

    @Test
    public void TestScaniatrunk() {
        Scania scania = new Scania();
        assertThrows(IllegalArgumentException.class, () -> scania.raiseTrunkAngle(1000000));
        scania.raiseTrunkAngle(20);
        assertThrows(IllegalArgumentException.class, scania::move);
    }

    @Test
    public  void TestTransporeter() {
        final int LOWERED = 1;
        final int RAISED = 0;
        Transporter transporter = new Transporter();
        transporter.lowerTrunkAngle();
        transporter.gas(0.5);
        assertEquals(LOWERED, transporter.getTrunkAngle(), 0.001);
        assertThrows(IllegalArgumentException.class, transporter::move);
        transporter.brake(1);
        transporter.raiseTrunkAngle();
        assertEquals(RAISED, transporter.getTrunkAngle(), 0.001);
        transporter.gas(0.5);
        transporter.move();
        transporter.brake(1);
        Volvo240 volvo240 = new Volvo240();
        Saab95 saab95 = new Saab95();
        Saab95 coolersaab95 = new Saab95();
        transporter.lowerTrunkAngle();
        assertThrows(IllegalArgumentException.class, () -> transporter.addCar(saab95));
        transporter.setX(0.25);
        transporter.setY(0.25);
        transporter.addCar(saab95);
        transporter.addCar(volvo240);
        assertThrows(IllegalArgumentException.class, () -> transporter.addCar(coolersaab95));
        transporter.raiseTrunkAngle();
        transporter.gas(0.5);
        transporter.move();
        transporter.move();
        assertEquals(saab95.getX(), transporter.getX(), 0.001);
        transporter.brake(1);
        transporter.lowerTrunkAngle();
        transporter.releaseCar();
        transporter.raiseTrunkAngle();
        transporter.gas(0.5);
        transporter.move();
        transporter.move();
        transporter.brake(1);
        assertNotEquals(transporter.getY(), volvo240.getY(), 0.0);
        // Scania scania = new Scania();
        // assertThrows(IllegalArgumentException.class, () -> transporter.addCar(scania));


    }
}
