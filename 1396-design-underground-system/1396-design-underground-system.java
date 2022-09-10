class UndergroundSystem {

    Map<Integer, String> trackID;
    Map<String, Integer> trackAverageTime;
    Map<String, Integer> trackTravelCount;
    public UndergroundSystem() {
        trackID = new HashMap<>();
        trackAverageTime = new HashMap<>();
        trackTravelCount = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        stationName = stationName + "," + t;
        trackID.put(id, stationName);
    }
    
    public void checkOut(int id, String stationName, int t) {
        String[] values = trackID.get(id).split(",");
        String startEndName = values[0] + "," + stationName;
        t -= Integer.parseInt(values[1]);
        trackAverageTime.put(startEndName, trackAverageTime.getOrDefault(startEndName, 0) + t);
        trackTravelCount.put(startEndName, trackTravelCount.getOrDefault(startEndName, 0) + 1);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String name = startStation + "," + endStation;
        int totalTime = trackAverageTime.get(name);
        int totalTravelCount = trackTravelCount.get(name);
        return (double) totalTime / totalTravelCount;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */