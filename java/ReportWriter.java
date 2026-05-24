import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportWriter {

    public static void writeReport(String filename, List<IndustrialAsset> assets) {
        StringBuilder sb = new StringBuilder();
        sb.append("INDUSTRIAL ASSET REPORT\n");
        sb.append("=======================\n\n");

        for (IndustrialAsset asset : assets) {
            sb.append("Name          : ").append(asset.getName()).append("\n");
            sb.append("Serial Number : ").append(asset.getSerialNumber()).append("\n");
            sb.append(String.format("Base Value    : $%.2f%n", asset.getBaseValue()));

            if (asset instanceof ElectronicSensor) {
                ElectronicSensor s = (ElectronicSensor) asset;
                double eff = SensorUtils.calculateEfficiency(s.getCurrentReading(), 100.0);
                sb.append(String.format("Voltage       : %.1f V%n", s.getVoltage()));
                sb.append(String.format("Reading       : %.2f%n", s.getCurrentReading()));
                sb.append(String.format("Efficiency    : %.1f%%%n", eff));
            }
            sb.append("\n");
        }

        // Write to file
        try (FileWriter fw = new FileWriter(filename)) {
            fw.write(sb.toString());
            System.out.println("Report saved to: " + filename);
        } catch (IOException e) {
            System.out.println("[ERROR] Could not write report: " + e.getMessage());
        }
    }
}
