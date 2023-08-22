public class SortColors {
    public static int[] sortColors (int[] colors) {
        final var N = colors.length;
        var i = 0;
        var l = 0;
        var r = N-1;
        while (i <= r) {
            if (colors[i] == 0) swap(colors, i++, l++);
            else if (colors[i] == 1) i++;
            else swap(colors, i, r--);
        }
        return colors;
    }
    
    private static void swap(int[] nums, int i, int j) {
        final var tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
