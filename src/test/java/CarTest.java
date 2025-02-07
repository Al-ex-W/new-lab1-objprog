import org.junit.jupiter.api.Test;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {
    @Test
    public void Testdoors(){
        Saab95 saab = new Saab95();
        assertEquals(2, saab.getNrDoors());
    }
    @Test
    public void TestSetColor(){
        Saab95 saab = new Saab95();
        saab.setColor(Color.blue);
        assertEquals(Color.blue, saab.getColor());
    }
    @Test
    public void TestStartStopEngine(){
        Saab95 saab = new Saab95();
        saab.startEngine();
        assertEquals(0.1, saab.getCurrentSpeed(), 0.001);
        saab.stopEngine();
        assertEquals(0, saab.getCurrentSpeed(), 0.001);
    }

    @Test
    public void TestSaabGasBrake(){
        Saab95 saab = new Saab95();
        saab.startEngine();
        saab.setTurboOn();
        saab.gas(0.7);
        assertEquals((0.1+(1.3*0.01*125)*0.7), saab.getCurrentSpeed(), 0.001);
        saab.brake(0.3);
        assertEquals(((0.1+(1.3*0.01*125)*0.7)-(1.3*0.01*125*0.3)), saab.getCurrentSpeed(), 0.001);
    }

    @Test
    public void TestMove(){
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
    public void TestVolvoGasBrake(){
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        volvo.gas(0.3);
        assertEquals((0.1+(1.25*0.01*100)*0.3), volvo.getCurrentSpeed(), 0.001);
        volvo.brake(0.04);
        assertEquals(((0.1+(1.25*0.01*100)*0.3)-(1.25*0.01*100*0.04)), volvo.getCurrentSpeed(), 0.001);
    }

    @Test
    public void Testgasbrakeinterval(){
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
}
