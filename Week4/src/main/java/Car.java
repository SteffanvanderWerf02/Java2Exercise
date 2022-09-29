import java.awt.*;

public class Car {
    private String licensePlate;
    private Color color;

    public Car(String licensePlate, Color color) {
        this.licensePlate = licensePlate;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }


}