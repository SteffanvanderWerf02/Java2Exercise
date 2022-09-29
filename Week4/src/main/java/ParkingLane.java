import java.util.Arrays;
import java.util.Iterator;

public class ParkingLane {
    private final int MAX_AMOUNT = 23;
    private Car[] parkedCars;

    public ParkingLane() {
        this.parkedCars = new Car[MAX_AMOUNT];
    }
    public int getAmountParkedCars() {
        int counter = 0;
        for (int i = 0; i < this.parkedCars.length; i++)
            if (this.parkedCars[i] != null){
                counter++;
            }
        return counter;
    }

    public void setParkedCars(Car[] parkedCars) {
        this.parkedCars = parkedCars;
    }

    /**
     * Park a car on the lane
     * @param newCar new car that wants to park
     * @return returns true or faslse if car can park on that lane
     */
    public boolean parkCar(Car newCar) {
        if (!this.checkIfcarIsAlreadyParked(newCar)) {
            for (int parkNumber = 0; parkNumber < parkedCars.length; parkNumber++) {
                if (this.parkedCars[parkNumber] == null) {
                    this.parkedCars[parkNumber] = newCar;
                    break;
                }
            }
            return true;
        }
        return false;
    }
    public Car getCar(int index) {
        return this.parkedCars[index];
    }

    /**
     * Check if the car isn't already parked on the lane
     * @param newCar new car that wants to park
     * @return returns true or false if car is already parked on that lane
     */
    public boolean checkIfcarIsAlreadyParked(Car newCar) {
        for (Car car : this.parkedCars) {
            if (newCar.equals(car)) {
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
    public boolean removeCarFromLane(String licencePlate) {
        Iterator<Car> car = Arrays.stream(this.parkedCars).iterator();
        while (car.hasNext()) {
            Car listCar = car.next();
            if (listCar == null) {
                return false;
            }
            if (listCar.getLicensePlate().equals(licencePlate)) {
                this.parkedCars[Arrays.asList(this.parkedCars).indexOf(listCar)] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * Check if there is space left on that parking number and return of it is free or occupied
     * @param parkingNumber number of the parking space
     * @return returns free or occupied
     */
    public String checkIfSpaceIsFree(int parkingNumber) {
        return this.parkedCars[parkingNumber] == null && parkingNumber < this.MAX_AMOUNT? "Free" : "Occupied";
    }

}