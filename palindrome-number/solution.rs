impl Solution {
    pub fn is_palindrome(x: i32) -> bool {
        if x < 0 { return false; }
        if x < 10 { return true; }
        let mut l = 1u64;
        let mut len = 0;
        let _x = x as u64;
        while _x / l > 0 {
            l *= 10;
            len += 1;
        }
        l /= 10;
        let mut r = 10u64;
        for _ in 0..len/2 {
            if (_x / l) % 10 != (_x % r) / (r / 10) {
                return false;
            }
            l /= 10;
            r *= 10;
        }
        true
    }
}
