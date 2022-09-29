import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    private ParkingLot parkingLot;
    private ParkingLane parkingLane;
    private Car car;
    @BeforeEach
    void setUp() {
        car = new Car("1-ABC-123", Color.BLACK);
        parkingLot = new ParkingLot("Test", Color.BLACK);
        parkingLane = new ParkingLane();
        parkingLot.addParkingLaneTolot(parkingLane);


    }

    @Test
    void parkCarTest() {
        assertTrue(parkingLot.parkCar(car));
        assertEquals(1, parkingLot.getParkedCarsInLot());
    }

    @Test
    void removeCarFromParkingLotTest() {
        parkingLot.parkCar(car);
        assertEquals(1, parkingLot.getParkedCarsInLot());
        assertTrue(parkingLot.removeCarFromParkingLot(car.getLicensePlate()));
    }

    @Test
    void checkIfParkingNumberIsFreeTest() {
       assertEquals("Free",parkingLot.checkIfParkingNumberIsFree(1, 0));
        parkingLot.parkCar(car);
        assertEquals("Occupied", parkingLot.checkIfParkingNumberIsFree(0, 0));
    }
}