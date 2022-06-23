class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        final var N = firstList.length;
        final var M = secondList.length;
        var i = 0;
        var j = 0;
        final List<int[]> aux = new ArrayList<>();
        while (i < N && j < M) {
            final var left = Math.max(firstList[i][0], secondList[j][0]);
            final var right = Math.min(firstList[i][1], secondList[j][1]);
            if (left <= right)
                aux.add(new int[]{left,right});
            if (firstList[i][1] < secondList[j][1]) i++;
            else j++;
        }

        return aux.toArray(new int[aux.size()][]);
    }
}
