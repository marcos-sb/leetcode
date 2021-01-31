func canFormArray(arr []int, pieces [][]int) bool {
    m := make([]int, 101) // map[element]position_of_next
    for i, _ := range m {
        m[i] = -1
    }
    for i, v := range arr {
        m[v] = i // m[v] == -1 <=> v not in m
    }
    
    for _, p := range pieces {
        // arr and pieces:
        // - same length
        // - no dups
        // all pieces in arr <=> all els of arr in pieces
        if !allPresent(p, m) {
            return false
        }
    }
    
    for _, p := range pieces {
        if !followsOrdering(p, m) {
            return false
        }
    }
    
    return true
}

func allPresent(els, m []int) bool {
    for _, el := range els {
        if i := m[el]; i == -1 {
            return false
        }
    }
    return true
}

func followsOrdering(els, m []int) bool {
    head := els[0]
    tail := els[1:]
    for _, v := range tail {
        if m[v] != m[head]+1 { // element of piece follows the same order as in arr
            return false
        }
        head = v
    }
    return true
}
