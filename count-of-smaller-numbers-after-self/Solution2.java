class Solution {
    public List<Integer> countSmaller(int[] nums) {
        final var N = nums.length;
        final var idx = new int[N];
        for (int i = 0; i < N; i++) idx[i] = i;
            
        final var res = new int[N];
        sort(nums, res, idx, 0, N-1, new int[N]);
        
        final var resL = new ArrayList<Integer>(N);
        for (var i = 0; i < N; i++) resL.add(res[i]);
        
        return resL;
    }
    
    private static void sort(int[] nums, int[] res, int[] idx, int l, int r, int[] aux) {
        if (r <= l) return;
        final var mid = l + (r-l)/2;
        sort(nums, res, idx, l, mid, aux);
        sort(nums, res, idx, mid+1, r, aux);
        merge(nums, res, idx, l, mid, r, aux);
    }
    
    private static void merge(int[] nums, int[] res, int[] idx, int l, int mid, int r, int[] aux) {
        var i = l;
        var j = mid+1;
        for (var k = l; k <= r; k++) {
            if (mid < i) aux[k] = idx[j++];
            else if (r < j) {
                res[idx[i]] += (j-mid-1);
                aux[k] = idx[i++];
            } else if (nums[idx[i]] <= nums[idx[j]]) {
                res[idx[i]] += (j-mid-1);
                aux[k] = idx[i++];
            } else aux[k] = idx[j++];
        }
        for (var k = l; k <= r; k++)
            idx[k] = aux[k];
    }
}
