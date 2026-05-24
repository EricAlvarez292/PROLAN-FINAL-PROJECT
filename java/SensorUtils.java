import java.util.List;
import java.util.stream.Collectors;

public class SensorUtils {

    public static double calculateEfficiency(double reading, double maxScale) {
        double efficiency = (reading / maxScale) * 100.0; // local variable
        return efficiency;
    }

    public static List<ElectronicSensor> filterCritical(List<IndustrialAsset> assets) {
        return assets.stream()
                .filter(a -> a instanceof ElectronicSensor)
                .map(a -> (ElectronicSensor) a)
                .filter(s -> s.getCurrentReading() > 75.0)
                .collect(Collectors.toList());
    }
}
