class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        final var stack = new int[asteroids.length];
        var lst = -1;
        for (var ast : asteroids) {
            while (lst >= 0 &&
                   stack[lst] > 0 && ast < 0 &&
                   Math.abs(stack[lst]) < Math.abs(ast)) {
                lst--;
            }
            if (lst == -1) stack[++lst] = ast;
            else if (!(stack[lst] > 0 && ast < 0))
                stack[++lst] = ast;
            else if (Math.abs(stack[lst]) == Math.abs(ast))
                lst--;
        }
        
        return Arrays.copyOfRange(stack, 0, lst+1);
    }
}
