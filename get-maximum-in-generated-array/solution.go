func getMaximumGenerated(n int) int {
    nums := make([]int, n+2)
    nums[0] = 0
    nums[1] = 1
    for i := 1; i <= n/2; i++ {
        nums[2*i] = nums[i]
        nums[2*i+1] = nums[i] + nums[i+1]
    }
    
    max := 0
    for i := 0; i < len(nums)-1; i++ {
        v := nums[i]
        if v > max {
            max = v
        }
    }
    
    return max
}
