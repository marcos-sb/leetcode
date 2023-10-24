class Solution {
    public int numRescueBoats(int[] people, int limit) {
        final var N = people.length;
        
        Arrays.sort(people); // O(N*log(N))

        var l = 0;
        var r = N-1;
        var boats = 0;
        while (l <= r) { // O(N)
            if (l == r) { boats++; break; }
            if (people[l] + people[r] <= limit) l++;
            r--; boats++;
        }
        
        return boats;
    }
}
