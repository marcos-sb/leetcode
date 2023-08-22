import java.util.*;

public class Main{
    public static boolean isHappyNumber(int n) {
        var slow = n;
        var fast = sumDigits(n);
        while (fast != 1 && fast != slow) {
            slow = sumDigits(slow);
            fast = sumDigits(sumDigits(fast));
        }
        return fast == 1;
    }
    
    private static int sumDigits(int n) {
        var res = 0;
        while (0 < n) {
            res += (n%10) * (n%10);
            n /= 10;
        }
        return res;
    }
}
