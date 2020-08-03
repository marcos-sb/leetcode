class Solution {
    public double angleClock(int hour, int minutes) {
        final int zeroHour = hour % 12;
        final double zeroHourAngleDeg = 360d/12 * zeroHour + 360d/12/60 * minutes;
        final double minutesAngleDeg = 360d/60 * minutes;
        final double angleDiffDeg = Math.abs(zeroHourAngleDeg - minutesAngleDeg);
        
        return Math.min(angleDiffDeg, 360 - angleDiffDeg);
    }
}
