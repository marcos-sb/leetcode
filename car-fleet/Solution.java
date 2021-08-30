class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        final var idx = new int[target];
        for (var i = 0; i < position.length; i++) idx[position[i]] = i;
        
        Arrays.sort(position);
        
        var res = 0;
        final var aux = new float[position.length+1];
        aux[aux.length-1] = 0;
        for (var i = aux.length-2; i >= 0; i--) {
            aux[i] = (target-position[i]) / (float) speed[idx[position[i]]];
            if (aux[i] - aux[i+1] > 0) res++;
            else aux[i] = aux[i+1];
        }

        return res;
    }
}
