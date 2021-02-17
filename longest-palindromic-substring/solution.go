func longestPalindrome(s string) string {
	longest := 0
	res := ""

  // odd-length palindromes
	for ri, _ := range s {
		for i := 0; i <= len(s)/2; i++ {
			l := ri - i
			r := ri + i
			if l < 0 || r >= len(s) || s[l] != s[r] {
				break
			}
			if longest < i*2+1 {
				longest = i*2 + 1
				res = s[l : r+1]
			}
		}
	}

  // even-length palindromes
	for l := 0; l < len(s)-1; l++ {
		r := l + 1
		if s[l] != s[r] {
			continue
		}
		for i := 0; i < len(s)/2; i++ {
			ll := l - i
			rr := r + i
			if ll < 0 || rr >= len(s) || s[ll] != s[rr] {
				break
			}
			if longest < rr-ll+1 {
				longest = rr - ll + 1
				res = s[ll : rr+1]
			}
		}
	}

	return res
}
