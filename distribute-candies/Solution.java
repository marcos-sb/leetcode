class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        final int[] res = new int[num_people];
        
        int num = 1;
        while (candies > 0) {
            for (int i = 0; i < res.length; i++) {
                if (candies - num > 0) {
                    res[i] += num;
                    candies -= num;
                    num++;
                } else {
                    res[i] += candies;
                    candies = 0;
                    break;
                }
            }
        }
        
        return res;
    }
}
