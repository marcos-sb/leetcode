class MyCalendarTwo {
    private final List<int[]> bookings;
    private final List<int[]> overlaps;

    public MyCalendarTwo() {
        this.bookings = new ArrayList<>();
        this.overlaps = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (var booking : overlaps) {
            if (Math.max(start, booking[0]) < Math.min(end, booking[1])) {
                return false;
            }
        }

        for (var booking : bookings) {
            final var overlapStart = Math.max(start, booking[0]);
            final var overlapEnd = Math.min(end, booking[1]);

            if (overlapStart < overlapEnd) {
                overlaps.add(new int[]{overlapStart, overlapEnd});
            }
        }

        bookings.add(new int[]{start, end});

        return true;
    }
}
