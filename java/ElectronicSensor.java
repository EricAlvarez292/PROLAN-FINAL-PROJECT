// Child class — inherits from IndustrialAsset — Part 1 & 2
public class ElectronicSensor extends IndustrialAsset {

    private double voltage;
    private double currentReading;

    public ElectronicSensor(String name, String serialNumber, double baseValue, double voltage, double currentReading) {
        super(name, serialNumber, baseValue);
        this.voltage = voltage;
        this.currentReading = currentReading;
    }

    public double getVoltage() {
        return voltage;
    }

    public double getCurrentReading() {
        return currentReading;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public void setCurrentReading(double currentReading) {
        this.currentReading = currentReading;
    }

    public void calibrate(double newReading) {
        this.currentReading = newReading;
        System.out.println("  [Calibrated] " + getName() + " -> New Reading: " + newReading);
    }

    @Override
    public void displaySpecs() {
        super.displaySpecs();
        System.out.printf("  Voltage       : %.1f V%n", voltage);
        System.out.printf("  Reading       : %.2f%n", currentReading);
    }
}
