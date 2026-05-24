import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ElectronicSensor pressureSensor = new ElectronicSensor(
                "Pressure Sensor", "SN-001", 1200.00, 24.0, 68.5);
        pressureSensor.calibrate(82.3);

        ArrayList<IndustrialAsset> assets = new ArrayList<>();
        assets.add(new IndustrialAsset("Control Panel", "SN-100", 5000.00));
        assets.add(pressureSensor);
        assets.add(new ElectronicSensor("Temp Sensor", "SN-002", 800.00, 12.0, 55.0));
        assets.add(new IndustrialAsset("Conveyor Belt Unit", "SN-101", 3200.00));

        System.out.println();

        for (IndustrialAsset asset : assets) {
            System.out.println("------------------------------");
            asset.displaySpecs();
        }
        System.out.println("------------------------------");
    }
}
