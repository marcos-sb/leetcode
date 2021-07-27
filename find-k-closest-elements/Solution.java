class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0;
        int hi = arr.length-k;
        while (lo < hi) {
            final int mid = (hi-lo)/2 + lo;
            if (x - arr[mid] > arr[mid+k] - x)
                lo = mid+1;
            else
                hi = mid;
        }
        final List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++)
            res.add(arr[lo+i]);
        return res;
    }
}
