class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        final var N = nums.length;
        final var res = new double[N-k+1];
        final var leftHalfI = new TreeSet<Integer>(
                (i,j) -> nums[i] != nums[j] ? Integer.compare(nums[i], nums[j]) : Integer.compare(i, j));
        final var rightHalfI = new TreeSet<Integer>(leftHalfI.comparator());

        for (var i = 0; i < k; i++) leftHalfI.add(i); // O(k * log(k))
        for (var i = 0; i < k/2; i++) rightHalfI.add(leftHalfI.pollLast()); // O(k * log(k))
        res[0] = median(leftHalfI, rightHalfI, nums);

        for (var i = k; i < N; i++) { // O(N * log(k))
            if (!leftHalfI.remove(i-k)) rightHalfI.remove(i-k); // O(log(k))
            final var inNum = nums[i];
            if (leftHalfI.isEmpty() || inNum <= nums[leftHalfI.last()]) leftHalfI.add(i); // O(log(k))
            else rightHalfI.add(i);
            rebalance(leftHalfI, rightHalfI);
            res[i-k+1] = median(leftHalfI, rightHalfI, nums);
        }

        return res;
    }

    private double median(TreeSet<Integer> leftHalf, TreeSet<Integer> rightHalf, int[] nums) {
        if (leftHalf.size() == rightHalf.size())
            return ((long)nums[leftHalf.last()] + nums[rightHalf.first()]) / 2d;
        return nums[leftHalf.last()];
    }

    private void rebalance(TreeSet<Integer> leftHalf, TreeSet<Integer> rightHalf) {
        while (rightHalf.size() < leftHalf.size()+1) rightHalf.add(leftHalf.pollLast());
        while (leftHalf.size() < rightHalf.size()) leftHalf.add(rightHalf.pollFirst());
    }
}
