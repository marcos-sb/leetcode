class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        final var res = new ArrayList<Integer>(asteroids.length);
        for (var ast : asteroids) {
            while (!res.isEmpty() &&
                   res.get(res.size()-1) > 0 && ast < 0 &&
                   Math.abs(res.get(res.size()-1)) < Math.abs(ast)) {
                res.remove(res.size()-1);
            }
            if (res.isEmpty()) res.add(ast);
            else if (!(res.get(res.size()-1) > 0 && ast < 0))
                res.add(ast);
            else if (Math.abs(res.get(res.size()-1)) == Math.abs(ast))
                res.remove(res.size()-1);
        }
        
        final var resArr = new int[res.size()];
        int i = 0;
        for (var n : res) resArr[i++] = n;
        
        return resArr;
    }
}
