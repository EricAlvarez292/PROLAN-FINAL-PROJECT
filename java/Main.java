import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Data Ingestion ===");
        String[] rawReadings = { "82.3", "bad_data", "-300.0", "55.0" };

        for (String raw : rawReadings) {
            try {
                double reading = Double.parseDouble(raw); // throws NumberFormatException
                if (reading < 0)
                    throw new SensorFailureException("Impossible reading: " + reading);
                System.out.println("  Accepted : " + reading);
            } catch (NumberFormatException e) {
                System.out.println("  [NumberFormatException] Non-numeric input: " + raw);
            } catch (SensorFailureException e) {
                System.out.println("  [SensorFailureException] " + e.getMessage());
            } finally {
                System.out.println("  -> Ingestion attempt complete.\n");
            }
        }

        List<IndustrialAsset> assets = new ArrayList<>();
        assets.add(new IndustrialAsset("Control Panel", "SN-100", 5000.00));
        assets.add(new ElectronicSensor("Pressure Sensor", "SN-001", 1200.00, 24.0, 82.3));
        assets.add(new ElectronicSensor("Temp Sensor", "SN-002", 800.00, 12.0, 55.0));
        assets.add(new IndustrialAsset("Conveyor Belt Unit", "SN-101", 3200.00));

        System.out.println("=== Efficiency Report ===");
        for (IndustrialAsset asset : assets) {
            if (asset instanceof ElectronicSensor) {
                ElectronicSensor s = (ElectronicSensor) asset;
                double eff = SensorUtils.calculateEfficiency(s.getCurrentReading(), 100.0);
                System.out.printf("  %-20s | Efficiency: %.1f%%%n", s.getName(), eff);
            }
        }

        List<ElectronicSensor> critical = SensorUtils.filterCritical(assets);
        System.out.println("\n=== Critical Sensors ===");
        critical.forEach(s -> System.out.println("  " + s.getName() +
                " | Reading: " + s.getCurrentReading()));

        System.out.println();
        ReportWriter.writeReport("report.txt", assets);
    }
}
