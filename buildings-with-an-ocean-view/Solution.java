class Solution {
    public int[] findBuildings(int[] heights) {
        if (heights == null) return new int[0];
        
        var max = 0;
        final var res = new ArrayDeque<Integer>(heights.length);
        for (var i = heights.length-1; i >= 0; i--) {
            if (max < heights[i]) {
                max = heights[i];
                res.offerFirst(i);
            }
        }
        
        var i = 0;
        final var resArr = new int[res.size()];
        for (var n : res) resArr[i++] = n;
        
        return resArr;
    }
}
