public class Solution {
    /**
     * @param flights: the airline status from the city i to the city j
     * @param days: days[i][j] represents the maximum days you could take vacation in the city i in the week j
     * @return: the maximum vacation days you could take during K weeks
     */
    public int maxVacationDays(int[][] flights, int[][] days) {
        final int[][] cache = new int[flights.length][days[0].length];
        
        int maxVacation = mvd(flights, days, 0, 0, cache);
        for (int i = 0; i < flights[0].length; i++) {
            if (flights[0][i] == 1)
                maxVacation = Math.max(mvd(flights, days, 0, i, cache), maxVacation);
        }

        return maxVacation;
    }

    private static int mvd(int[][] flights, int[][] days, int week, int city, int[][] cache) {
        if (week == days[0].length) return days[city][week];
        if (cache[city][week] > 0) return cache[city][week];
        
        int vacation = days[city][week];
        int maxVacation = 0;
        for (int i = 0; i < flights[city].length; i++)
            if (flights[city][i] == 1)
                maxVacation = Math.max(vacation + mvd(flights, days, week+1, i, cache), maxVacation);

        maxVacation = Math.max(vacation + mvd(flights, days, week+1, city, cache), maxVacation);

        cache[city][week] = maxVacation;

        return maxVacation;
    }
}
