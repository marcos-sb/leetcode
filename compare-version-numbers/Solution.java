class Solution {
    public int compareVersion(String version1, String version2) {
        final var v1 = 
            Arrays.stream(version1.split("\\."))
                .mapToInt(Integer::parseInt).toArray();
        final var v2 =
            Arrays.stream(version2.split("\\."))
                .mapToInt(Integer::parseInt).toArray();
        final var shorter = v1.length < v2.length ? v1 : v2;
        final var longer = v1 == shorter ? v2 : v1;
        
        for (int i = 0; i < shorter.length; i++) {
            if (v1[i] < v2[i]) return -1;
            if (v2[i] < v1[i]) return 1;
        }
        for (int i = shorter.length; i < longer.length; i++) {
            if (0 < longer[i]) return longer == v2 ? -1 : 1;
        }
        
        return 0;
    }
}
