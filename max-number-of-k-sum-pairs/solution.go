func maxOperations(nums []int, k int) int {
    complFreq := make(map[int]int, len(nums))
    
    for _, n := range nums {
        if k-n > 0 {
            complFreq[k-n]++
        }
    }
    
    ops := 0
    for _, n := range nums {
        if _, ok := complFreq[n]; ok {
            complFreq[n]--
            if _, ok := complFreq[k-n]; ok {
                complFreq[k-n]--
                if complFreq[n] >= 0 && complFreq[k-n] >= 0 {
                    ops++
                }
            }
        }
    }
    
    return ops
}
