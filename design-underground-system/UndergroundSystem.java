class UndergroundSystem {
    static class OpenTripDetails {
        final String startingStation;
        final int checkinTime;
        OpenTripDetails(String startingStation, int checkinTime) {
            this.startingStation = startingStation;
            this.checkinTime = checkinTime;
        }
    }

    private final Map<Integer, OpenTripDetails> openTrips;
    private final Map<String, Map<String, List<Integer>>> closedTrips;

    public UndergroundSystem() {
        this.openTrips = new HashMap<>();
        this.closedTrips = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        openTrips.put(id, new OpenTripDetails(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        final var tripDetails = openTrips.get(id);
        closedTrips
            .computeIfAbsent(tripDetails.startingStation, (k) -> new HashMap<>())
            .computeIfAbsent(stationName, (k) -> new ArrayList<>())
            .add(t - tripDetails.checkinTime);
    }

    public double getAverageTime(String startStation, String endStation) {
        if (!closedTrips.containsKey(startStation)) return 0D;

        final var closedTripsFromStart = closedTrips.get(startStation);
        if (!closedTripsFromStart.containsKey(endStation)) return 0D;

        final var timesStartEnd = closedTripsFromStart.get(endStation);
        final var totalTime = (double) timesStartEnd.stream().reduce(0, (a,b) -> a+b);

        return totalTime / timesStartEnd.size();
    }
}
