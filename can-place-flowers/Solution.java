class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;

        final var f = flowerbed.length;
        for (var i = 0; i < f; ++i) {
            if (flowerbed[i] == 0 && ((0 < i && flowerbed[i-1] == 0) || 0 == i) && ((i < f-1 && flowerbed[i+1] == 0) || i == f-1)) {
                flowerbed[i] = 1;
                if (--n == 0) break;
            }
        }

        return n == 0;
    }
}
