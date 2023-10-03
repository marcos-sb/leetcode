class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        final var N = arr.length;
        
        var l = 0;
        var r = N-1;
        while (k < r-l+1) { // O(N-k)
            if (x - arr[l] <= arr[r] - x) r--;
            else l++;
        }

        final var res = new ArrayList<Integer>(k);
        for (var i = l; i <= r; i++) res.add(arr[i]); // O(k)
        return res;
    }
}
