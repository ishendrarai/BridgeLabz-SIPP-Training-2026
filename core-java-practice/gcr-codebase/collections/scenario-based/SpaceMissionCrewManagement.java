import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SpaceMissionCrewManagement {
    static class Astronaut {
        String astronautId;
        String name;
        String specialization;
        public Astronaut(String id, String name, String spec) {
            this.astronautId = id; this.name = name; this.specialization = spec;
        }
        @Override
        public String toString() { return name + " (" + specialization + ")"; }
    }
    
    private Map<String, List<Astronaut>> missions = new HashMap<>();
    private Map<String, Set<String>> missionAstronauts = new HashMap<>();
    
    public void addMission(String missionName) {
        missions.putIfAbsent(missionName, new ArrayList<>());
        missionAstronauts.putIfAbsent(missionName, new HashSet<>());
    }
    
    public boolean assignAstronaut(String missionName, Astronaut a) {
        addMission(missionName);
        if (missionAstronauts.get(missionName).add(a.astronautId)) {
            missions.get(missionName).add(a);
            return true;
        }
        return false;
    }
    
    public void displayMissions() {
        for (String mission : missions.keySet()) {
            List<Astronaut> crew = missions.get(mission);
            System.out.println("Mission: " + mission + " | Crew size: " + crew.size());
            for (Astronaut a : crew) {
                System.out.println("- " + a);
            }
        }
    }
}
