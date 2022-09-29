import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParkingLaneTest {

    private ParkingLane parkingLane;
    private Car car;
    @BeforeEach
    void setUp() {
        parkingLane = new ParkingLane();
        car = new Car("1-ABC-123", Color.BLACK);
    }
    @Test
    void parkCarTest() {
        assertTrue(parkingLane.parkCar(car));
        assertEquals(1,parkingLane.getAmountParkedCars());
        assertEquals(car,parkingLane.getCar(0));
    }

    @Test
    void checkIfcarIsAlreadyParkedTest() {
        parkingLane.parkCar(car);
        assertFalse(parkingLane.parkCar(car));
    }

    @Test
    void removeCarFromLaneTest() {
        parkingLane.parkCar(car);
        assertTrue(parkingLane.removeCarFromLane(car.getLicensePlate()));
        assertEquals(0,parkingLane.getAmountParkedCars());
        assertNotEquals(car,parkingLane.getCar(0));
    }

    @Test
    void checkIfSpaceIsFreeTest() {
        assertEquals("Free",parkingLane.checkIfSpaceIsFree(0));
        parkingLane.parkCar(car);
        assertEquals("Occupied", parkingLane.checkIfSpaceIsFree(0));

    }
}