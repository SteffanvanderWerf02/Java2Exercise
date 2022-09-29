import java.awt.*;

public class ParkingLot {
    private final int MAX_CAPACITYLANES = 24;
    private String Adres;
    private Color asphaultColor;
    private ParkingLane[] parkingLanes;

    public ParkingLot(String Adres, Color asphaultColor) {
        this.Adres = Adres;
        this.asphaultColor = asphaultColor;
        this.parkingLanes = new ParkingLane[MAX_CAPACITYLANES];
    }

    public void setAdres(String adres) {
        Adres = adres;
    }

    public String getAdres() {
        return Adres;
    }

    public void setAsphaultColor(Color asphaultColor) {
        this.asphaultColor = asphaultColor;
    }

    public Color getAsphaultColor() {
        return asphaultColor;
    }

    public ParkingLane[] getParkingLanes() {
        return parkingLanes;
    }
    public int getParkedCarsInLot(){
        int counter = 0;
        for (int i = 0; i < this.parkingLanes.length; i++)
            if (this.parkingLanes[i] != null) {
                counter += this.parkingLanes[i].getAmountParkedCars();
            }
        return counter;
    }

    public int getAmountOfParkingLanes(){
        int counter = 0;
        for (int i = 0; i < this.parkingLanes.length; i++)
            if (this.parkingLanes[i] != null) {
                counter++;
            }
        return counter;
    }
    public void addParkingLaneTolot(ParkingLane parkingLane) {
        for (int i = 0; i < parkingLanes.length; i++) {
            if (parkingLanes[i] == null) {
                parkingLanes[i] = parkingLane;
                break;
            }
        }
    }

    /**
     * Park a car on the parking lot
     * @param newCar new car that wants to park
     * @return returns true or faslse if car can park on that parking lot
     */
    public boolean parkCar(Car newCar) {
        for (ParkingLane parkingLane : this.parkingLanes) {
            if (parkingLane.parkCar(newCar)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Remove the car trouch his licence plate
     * @param licencePlate String with the licence plate of the car that needs to be removed
     * @return Return true of false if the car is removed or not
     */
    public boolean removeCarFromParkingLot(String licencePlate) {
        for (ParkingLane parkingLane : this.parkingLanes) {
            if (parkingLane.removeCarFromLane(licencePlate)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if there is space left on that parking number and return of it is free or occupied
     * @param parkingNumber int with the parking number
     * @param parkingLane int with the parking lane
     * @return Return if the parking number is free or occupied
     */
    public String checkIfParkingNumberIsFree(int parkingNumber, int parkingLane) {
        return this.parkingLanes[parkingLane].checkIfSpaceIsFree(parkingNumber);
    }
}