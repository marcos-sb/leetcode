class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) return List.of();
        
        final List<List<Integer>> ret = new ArrayList<>(numRows);
        ret.add(List.of(1));
        for (var r = 1; r < numRows; r++) {
            final var prevRow = ret.get(r-1);
            
            final var row = new ArrayList<Integer>(r+1);
            row.add(1);
            for (var c = 0; c+1 < prevRow.size(); c++)
                row.add(prevRow.get(c) + prevRow.get(c+1));
            row.add(1);
            ret.add(row);
        }
        
        return ret;
    }
}
