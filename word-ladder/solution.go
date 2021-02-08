import "container/list"

type el struct {
	i, wordlen int
}

func ladderLength(beginWord string, endWord string, wordList []string) int {
	index := make(map[string]int, len(wordList)+1) // +1 in case beginWord not in wordList
	for i, w := range wordList {
		index[w] = i
	}
	if _, ok := index[endWord]; !ok {
		return 0
	}
	if _, ok := index[beginWord]; !ok {
		index[beginWord] = len(wordList)
		wordList = append(wordList, beginWord)
	}

	distances := make([][]int, len(index)) // levenshtein distance between all pairs in wordList
	for i := range distances {
		distances[i] = make([]int, len(index))
	}

	for w, i := range index {
		for j := i + 1; j < len(index); j++ {
			_d := d(w, wordList[j])
			distances[i][j] = _d
			distances[j][i] = _d
		}
	}

	visited := make(map[int]interface{}, 26)
	q := list.New()
	q.PushBack(el{i: index[beginWord], wordlen: 1})
	for front := q.Front(); front != nil; front = q.Front() {
		q.Remove(front)
		frontVal := front.Value.(el)
		if frontVal.i == index[endWord] {
			return frontVal.wordlen
		}
		visited[frontVal.i] = struct{}{}

		for i := 0; i < len(distances[frontVal.i]); i++ {
			_d := distances[frontVal.i][i]
			if _d == 1 {
				if _, ok := visited[i]; !ok {
					q.PushBack(el{i: i, wordlen: frontVal.wordlen + 1})
				}
			}
		}
	}

	return 0
}

func d(s1, s2 string) int {
	_d := 0
	for i, r := range s1 {
		if r != rune(s2[i]) {
			_d++
		}
	}
	return _d
}
