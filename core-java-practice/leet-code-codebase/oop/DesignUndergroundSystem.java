import java.util.HashMap;
import java.util.Map;

public class DesignUndergroundSystem {
    private Map<Integer, Event> checkIns = new HashMap<>();
    private Map<String, Route> routes = new HashMap<>();

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new Event(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Event event = checkIns.get(id);
        String routeName = event.stationName + "->" + stationName;
        int duration = t - event.time;
        
        routes.putIfAbsent(routeName, new Route());
        Route route = routes.get(routeName);
        route.totalTime += duration;
        route.tripCount++;
    }

    public double getAverageTime(String startStation, String endStation) {
        String routeName = startStation + "->" + endStation;
        Route route = routes.get(routeName);
        return (double) route.totalTime / route.tripCount;
    }

    private class Event {
        String stationName;
        int time;
        Event(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    private class Route {
        long totalTime;
        int tripCount;
    }
}
