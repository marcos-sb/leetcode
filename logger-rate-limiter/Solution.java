class Logger {
    private Map<String, Integer> throttledMessages;
    
    public Logger() {
        throttledMessages = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (timestamp < throttledMessages.getOrDefault(message, 0))
            return false;
        throttledMessages.put(message, timestamp+10);
        return true;
    }
}
