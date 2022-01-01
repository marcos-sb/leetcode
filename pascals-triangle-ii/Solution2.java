class Solution2 {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) return List.of(1);
        List<Integer> dp0 = new ArrayList<>(rowIndex+1){{add(1); add(1);}};
        List<Integer> dp1 = new ArrayList<>(dp0);
        while (--rowIndex > 0) {
            final var tmp = dp0;
            dp0 = dp1;
            dp1 = tmp;
            for (var i = 1; i < dp0.size(); i++)
                if (i < dp1.size()) dp1.set(i, dp0.get(i-1) + dp0.get(i));
                else dp1.add(dp0.get(i-1) + dp0.get(i));
            dp1.add(1);
        }
        return dp1;
    }
}
