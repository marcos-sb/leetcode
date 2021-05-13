public class Solution {
    // a + b = target => a = (target - b)
    public int[] twoSum(int[] numbers, int target) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++)
            map.put(target - numbers[i], i);
        
        for (int i = 0; i < numbers.length; i++)
            if (map.containsKey(numbers[i]) && map.get(numbers[i]) != i)
                return new int[]{i, map.get(numbers[i])};
        
        return new int[]{-1,-1};
    }
}
