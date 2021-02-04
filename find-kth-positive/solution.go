func findKthPositive(arr []int, k int) int {
    set := make(map[int]bool, len(arr))
    for _, n := range arr {
        set[n] = true
    }
    
    missing := 0
    for i := 1; ; i++ {
        if _, ok := set[i]; !ok {
            missing++;
            if (missing == k) { return i }
        }
    }
    
    return -1
}
