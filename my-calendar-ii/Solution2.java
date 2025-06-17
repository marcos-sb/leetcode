import java.util.SortedMap;

class MyCalendarTwo {
    private final SortedMap<Integer, Integer> calendar;

    public MyCalendarTwo() {
        this.calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        calendar.put(start, calendar.getOrDefault(start, 0) + 1);
        calendar.put(end, calendar.getOrDefault(end, 0) - 1);

        var overlapping = 0;
        for (var count : calendar.values()) {
            overlapping += count;
            if (3 <= overlapping) {
                final var startCount = calendar.get(start);
                final var endCount = calendar.get(end);

                if (startCount == 1) {
                    calendar.remove(start);
                } else {
                    calendar.put(start, startCount-1);
                }

                if (endCount == -1) {
                    calendar.remove(end);
                } else {
                    calendar.put(end, endCount+1);
                }

                return false;
            }
        }

        return true;
    }
}
