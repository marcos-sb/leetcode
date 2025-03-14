class MyCalendar {
    private final TreeSet<int[]> events;

    public MyCalendar() {
        events = new TreeSet<>((a,b) -> a[0] - b[0]);
    }

    public boolean book(int startTime, int endTime) {
        final var bookingTime = new int[]{startTime, endTime};
        final var floor = events.floor(bookingTime);
        final var ceiling = events.ceiling(bookingTime);
        if (floor != null && bookingTime[0] < floor[1] ||
            ceiling != null && ceiling[0] < bookingTime[1]) return false;
        return events.add(bookingTime);
    }
}
