class Solution {
    public int[] nextGreaterElements(int[] nums) {
        final var N = nums.length;
        final var res = new int[N];
        Arrays.fill(res, -1);

        final var st = new ArrayList<Integer>();
        for (var i = 0; i < N; i++) {
            final var n = nums[i];
            while (!st.isEmpty() && nums[st.get(st.size()-1)] < n) {
                res[st.remove(st.size()-1)] = n;
            }
            st.add(i);
        }

        for (var i = 0; i < N; i++) {
            final var n = nums[i];
            while (!st.isEmpty() && nums[st.get(st.size()-1)] < n) {
                res[st.remove(st.size()-1)] = n;
            }
            st.add(i);
        }

        return res;
    }
}
