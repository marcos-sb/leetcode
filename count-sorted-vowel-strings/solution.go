func countVowelStrings(n int) int {
    if n == 1 { return 5 }
    
    count := 0
    for i := 0; i < 5; i++ {
        count += countVS(n, i, 1)
    }
    return count
}

func countVS(n, vi, currLen int) int {
    if n == currLen { return 1 }
    
    count := 0
    for i := vi; i < 5; i++ {
        count += countVS(n, i, currLen+1)
    }
    return count
}
