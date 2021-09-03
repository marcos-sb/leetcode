import java.util.NavigableMap;

class MyCalendar {
    private final NavigableMap<Integer, Integer> start2end;
    
    public MyCalendar() {
        start2end = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        final var lowerStart = start2end.lowerEntry(end);
        if (lowerStart != null && start < lowerStart.getValue())
            return false;
        start2end.put(start, end);
        return true;
    }
}
