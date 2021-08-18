// full credit: https://leetcode.com/problems/sell-diminishing-valued-colored-balls/discuss/927509/Java-O(NlogN)-or-Detailed-Explanation-or-Runtime-Beats-100
//
// 1 3 4 6 8
// max sell value rounds
// 
// [1]
// 1 3 4 6 8
// --------^ count = 1
// max sell value => msv = 8 + 7 <= common diff (8,6); see comment for 'count' var below
//
// [2]
// 1 3 4 6 6 <- (the inventory array is not actually changed, this is unwrapped to ease the understanding of the algo)
// ------^ count = 2 => group of 2 repeated ball counts left in the inventory
// 1 3 4 6 6
// msv => cd(6,4) => 6 + 5 => 11 * count => 22
//
// unwrap => 6 6 5 5 => we can sell 4 balls in round [2]
//   => 2 of which we have inventory '6' => sell value = 6 + 6 = 12, => inventory of those 2 decrements by 1 to '5'
//   => 2 of which we have inventory '5' => sell value = 10, inv dec by 1 to '4'
//   => total: 12 + 10 => 22 (see L:14)
//
// [3]
// 1 3 4 4 4
// ----^ count = 3
// msv => cd(4,3) * count => 4 * 3 = 12
//
// and so on...
//
// EDGE CASES (else branch):
// => last item in the inventory (can't apply the common diff formula), or
// => not enough 'orders' left to completely sell all the balls in a round
//
// [1]
// orders = 6
// count = 4
// i = 1
// inventory = [1 3 4 5 6]
// ---------------^ i => unwrap => [ 1 2 2 2 2 3 3 3 3 (ignore already sold in previous rounds) ]
//
// msv with 6 orders left:
// 3 3 3 3 2 2 => msv = 4 * 3 + 2 = count * cd(3,2) + 2
//
// full = 6 / 4 = 1 => msv = count * cd(3, 3-full) => count * cd(3, 3-1) => 4 * 3
// rem = 6 % 4 = 2 => msv += 2 + 2

class Solution {
    private static final long mod = 1000_000_007;

    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);

        int count = 1; // number of times that the common difference repeats
                       // common diff of an AP => total sum of the elements between any two elements in an AP
                       // cd (7, 4) => 7+6+5+4+3+2+1 => 7+6+5 => 18 => max. value of the order if we have `inventory = [.., 4, 7]`
        int i = inventory.length-1; // start from the end => monotonic non-decreasing sort => start from 'max' inventory
        long ret = 0l;
        while (orders > 0) {
            if (i > 0 && inventory[i] - inventory[i-1] > 0 // if this diff is '0', `continue` until it's not
                                                           // the 'skipped' balls will be counted in the subsequent iterations
                      && orders >= count * (inventory[i]-inventory[i-1])) { // we have enough 'orders' left to sell all the balls between inv[i] (inc.) and inv[i-1] (exclusive)
                // add the total max value of the order
                ret += count * commonDiff(inventory[i], inventory[i-1]);
                // substract the actual number of balls sold
                // write down an example to visualise the role of 'count'
                orders -= count * (inventory[i] - inventory[i-1]);

            } else if (i == 0 || inventory[i] - inventory[i-1] > 0) { // last item in the inventory or not enough 'orders' left to perform a complete sell
                // total numbers of full orders we can sell with the 'orders' we have left and the number of times the remaining ball inventory repeats
                long full = orders / count;
                ret += count * commonDiff(inventory[i], inventory[i]-full);

                // remaining orders to fulfill
                long rem = orders % count;
                ret += rem * (inventory[i]-full);
                
                // there're no more orders we can fulfill, but we need to 'mod' the result (L:38), else we could have returned 'ret' here
                orders = 0;
            }
            i--;
            count++;
            ret %= mod;
        }
        
        return (int) ret;
    }
    
    private static long commonDiff(long a, long b) { // sum diff between any two terms in an arithmetic progression
        return a*(a+1)/2 - b*(b+1)/2;
    }
}
