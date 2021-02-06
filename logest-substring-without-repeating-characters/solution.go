func lengthOfLongestSubstring(s string) int {
    set := make(map[rune]int, 26)
    
    var maxLen, start int
    for i, r := range s {
        if _, ok := set[r]; ok {
            currLen := i - start
            if currLen > maxLen {
                maxLen = currLen
            }
            dupPos := set[r]
            for _, _r := range s[start:dupPos] {
                delete(set, _r)
            }
            set[r] = i
            start = dupPos+1 // ascii string
        } else {
            set[r] = i
        }
    }
    
    tailLen := len(s) - start
    if tailLen > maxLen {
        return tailLen
    }
    return maxLen
}
