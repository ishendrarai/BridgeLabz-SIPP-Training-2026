import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SmartCityTrafficMonitoring {
    private Map<String, Integer> trafficData = new HashMap<>();
    
    public void updateVehicleCount(String roadName, int count) {
        trafficData.put(roadName, trafficData.getOrDefault(roadName, 0) + count);
    }
    
    public void displaySortedRoads() {
        TreeMap<String, Integer> sortedData = new TreeMap<>(trafficData);
        for (Map.Entry<String, Integer> entry : sortedData.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " vehicles");
        }
    }
    
    public String getBusiestRoad() {
        String busiest = null;
        int max = -1;
        for (Map.Entry<String, Integer> entry : trafficData.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                busiest = entry.getKey();
            }
        }
        return busiest;
    }
    
    public void generateReport() {
        System.out.println("--- Traffic Report ---");
        System.out.println("Total roads monitored: " + trafficData.size());
        displaySortedRoads();
        System.out.println("Busiest Road: " + getBusiestRoad());
    }
}
