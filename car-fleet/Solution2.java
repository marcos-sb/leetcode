class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        final var idx = new int[target];
        for (var i = 0; i < position.length; i++) idx[position[i]] = i;
        
        Arrays.sort(position);
        
        var res = 0;
        var maxSteps = 0f;
        for (var i = position.length-1; i >= 0; i--) {
            final var steps = (target-position[i]) / (float) speed[idx[position[i]]];
            if (steps > maxSteps) res++;
            maxSteps = Math.max(steps, maxSteps);
        }

        return res;
    }
}
