import java.util.ArrayList;

public class SensorProcessor {

    public static void main(String[] args) {

        ArrayList<Object> sensorData = new ArrayList<>();

        sensorData.add("SENSOR-A1");  sensorData.add(82.5);
        sensorData.add("SENSOR-B2");  sensorData.add(45.0);
        sensorData.add("SENSOR-C3");  sensorData.add(91.3);
        sensorData.add("SENSOR-D4");  sensorData.add(60.7);
        sensorData.add("SENSOR-E5");  sensorData.add(78.1);
        sensorData.add("SENSOR-F6");  sensorData.add(33.4);
        sensorData.add("SENSOR-G7");  sensorData.add(88.9);
        sensorData.add("SENSOR-H8");  sensorData.add(55.2);
        sensorData.add("SENSOR-I9");  sensorData.add(76.0);
        sensorData.add("SENSOR-J10"); sensorData.add(42.8);

        final double THRESHOLD = 75.0;

        String  currentId = null;
        double  total     = 0.0;
        int     count     = 0;
        double  highest   = Double.MIN_VALUE;

        String separator = "+---------------+----------+----------+";
        System.out.println(separator);
        System.out.printf("| %-13s | %-8s | %-8s |%n", "ID", "Reading", "Status");
        System.out.println(separator);

        for (Object item : sensorData) {

            if (item instanceof String) {
                currentId = (String) item;

            } else if (item instanceof Double) {
                double reading = (Double) item;

                total += reading;
                count++;

                if (reading > highest) {
                    highest = reading;
                }

                String status = (reading > THRESHOLD) ? "CRITICAL" : "NORMAL";

                System.out.printf("| %-13s | %8.1f | %-8s |%n",
                                  currentId, reading, status);
            }
        }

        System.out.println(separator);

        if (count > 0) {
            double average = total / count;
            System.out.println();
            System.out.printf("  Average Reading : %.2f%n", average);
            System.out.printf("  Highest Reading : %.2f%n", highest);
        }
    }
}
