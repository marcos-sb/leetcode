package two_city_scheduling;

import java.util.Arrays;

public class Solution {
    int countA = 0;
    int countB = 0;
    int totalCost = 0;

    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> Math.abs(b[0]-b[1]) - Math.abs(a[0]-a[1]));

        for (int[] pc : costs) {
            if (pc[0] <= pc[1]) {
                if (countA < costs.length/2)
                    sendToA(pc[0]);
                else sendToB(pc[1]);
            } else {
                if (countB < costs.length/2)
                    sendToB(pc[1]);
                else sendToA(pc[0]);
            }
        }
        return totalCost;
    }
    private void sendToA(int cost) {
        countA++;
        totalCost += cost;
    }
    private void sendToB(int cost) {
        countB++;
        totalCost += cost;
    }
}
