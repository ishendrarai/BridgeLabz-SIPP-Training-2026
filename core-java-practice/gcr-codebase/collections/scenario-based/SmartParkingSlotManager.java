import java.util.ArrayList;
import java.util.List;

public class SmartParkingSlotManager {
    private List<String> parkedVehicles = new ArrayList<>();
    
    public void addVehicle(String regNo) {
        if (!parkedVehicles.contains(regNo)) {
            parkedVehicles.add(regNo);
        }
    }
    
    public void removeVehicle(String regNo) {
        parkedVehicles.remove(regNo);
    }
    
    public boolean isParked(String regNo) {
        return parkedVehicles.contains(regNo);
    }
    
    public void displayAll() {
        System.out.println("Total Occupied Slots: " + parkedVehicles.size());
        for (String regNo : parkedVehicles) {
            System.out.println(regNo);
        }
    }
}
