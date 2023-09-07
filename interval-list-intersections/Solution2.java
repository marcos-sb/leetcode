class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        final var N = firstList.length;
        final var M = secondList.length;
        final var res = new ArrayList<int[]>();
        
        var i = 0;
        var j = 0;
        while (i < N && j < M) {
            if (firstList[i][0] <= secondList[j][1] && secondList[j][0] <= firstList[i][1]) {
                final var maxL = Math.max(firstList[i][0], secondList[j][0]);
                final var minR = Math.min(firstList[i][1], secondList[j][1]);
                res.add(new int[]{maxL, minR});
            }
            if (firstList[i][1] < secondList[j][1]) i++;
            else if (secondList[j][1] < firstList[i][1]) j++;
            else { i++; j++; }
        }

        return res.toArray(new int[0][2]);
    }
}
