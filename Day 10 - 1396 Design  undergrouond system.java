import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {
    private static class Event {
        String stationName;
        int time;

        Event(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }
    private static class JourneyStats {
        double totalTime;
        int count;

        JourneyStats(double totalTime, int count) {
            this.totalTime = totalTime;
            this.count = count;
        }
    }

    private Map<Integer, Event> checkInMap;
    private Map<String, JourneyStats> journeyMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        journeyMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Event(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Event checkInEvent = checkInMap.get(id);
        String startStation = checkInEvent.stationName;
        int startTime = checkInEvent.time;
        
        String routeKey = startStation + "->" + stationName;
        int travelTime = t - startTime;
        
        JourneyStats stats = journeyMap.getOrDefault(routeKey, new JourneyStats(0, 0));
        stats.totalTime += travelTime;
        stats.count += 1;
        
        journeyMap.put(routeKey, stats);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        JourneyStats stats = journeyMap.get(routeKey);
        return stats.totalTime / stats.count;
    }
}
