public class IndustrialAsset {

    private String name;
    private String serialNumber;
    private double baseValue;

    public IndustrialAsset(String name, String serialNumber, double baseValue) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.baseValue = baseValue;
    }

    public String getName() {
        return name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getBaseValue() {
        return baseValue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setBaseValue(double baseValue) {
        this.baseValue = baseValue;
    }

    public void displaySpecs() {
        System.out.println("  Name          : " + name);
        System.out.println("  Serial Number : " + serialNumber);
        System.out.printf("  Base Value    : $%.2f%n", baseValue);
    }
}
