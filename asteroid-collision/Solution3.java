class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        final var stack = new ArrayList<Integer>();
        for (var a : asteroids) {
            if (stack.isEmpty() || a > 0 || (a < 0 && stack.get(stack.size()-1) < 0)) stack.add(a);
            else {
                while (!stack.isEmpty() && stack.get(stack.size()-1) > 0 && stack.get(stack.size()-1) < -a)
                    stack.remove(stack.size()-1);
                if (stack.isEmpty() || stack.get(stack.size()-1) < 0) stack.add(a);
                else if (stack.get(stack.size()-1) == -a)
                    stack.remove(stack.size()-1);
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }
}
