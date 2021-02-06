func arrayStringsAreEqual(word1 []string, word2 []string) bool {
    _visit := visit(word2)
    for _, w := range word1 {
        for _, r1 := range w {
            if r2, eof := _visit(); eof || r1 != r2 {
                return false
            }
        }
    }
    _, eof := _visit() // the last visit must return eof
    return eof
}

func visit(word []string) func() (rune, bool) {
    w := 0
    wi := 0
    
    var _visit func() (rune, bool)
    _visit = func() (rune, bool) {
        if w >= len(word) { return 0, true }
        if wi >= len(word[w]) {
            w++
            wi = 0
            return _visit() // at most once rec call per invocation
        }
        next := rune(word[w][wi])
        wi++
        return next, false
    }
    
    return _visit
}
