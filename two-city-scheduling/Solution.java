class Solution {
    public int twoCitySchedCost(int[][] costs) {
        final var N = costs.length/2;

        // Local optimal: decide first where to fly those with the highest cost difference
        Arrays.sort(costs, (a,b) -> Integer.compare(Math.abs(b[0]-b[1]), Math.abs(a[0]-a[1])));

        var flyA = 0;
        var flyB = 0;
        var flyCost = 0;
        for (var pc : costs) {
            if (pc[0] <= pc[1]) {
                if (flyA < N) {
                    flyCost += pc[0];
                    flyA++;
                } else {
                    flyCost += pc[1];
                    flyB++;
                }
            } else {
                if (flyB < N) {
                    flyCost += pc[1];
                    flyB++;
                } else {
                    flyCost += pc[0];
                    flyA++;
                }
            }
        }

        return flyCost;
    }
}
