func countArrangement(n int) int {
	bo := make([]map[int]bool, n+1) // beautiful options
	for i := range bo { // O(n)
		bo[i] = make(map[int]bool, 4)
	}

	for i := 1; i <= n; i++ { // O(n^2)
		for j := i; j <= n; j++ { // O(n)
			if j%i == 0 {
				bo[i][j] = true
				bo[j][i] = true
			}
		}
	}

	count := 0
	for opt := range bo[1] {
		bt(2, bo, map[int]bool{opt: true}, &count) // O(prod(len(maps in bo)))
	}

	return count
}

func bt(i int, bo []map[int]bool, used map[int]bool, count *int) { // backtrack
	if i >= len(bo) {
		*count++
		return
	}

	for opt := range bo[i] {
		if _, ok := used[opt]; !ok {
			used[opt] = true
			bt(i+1, bo, used, count)
			delete(used, opt)
		}
	}
}

