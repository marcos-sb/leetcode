class Solution {
    private static final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
    
    public boolean halvesAreAlike(String s) {
        int vowelBalance = 0;
        for (int i = 0; i < s.length()/2; i++) {
            if (vowels.contains(Character.toLowerCase(s.charAt(s.length()-1-i)))) vowelBalance++;
            if (vowels.contains(Character.toLowerCase(s.charAt(i)))) vowelBalance--;
        }
        return vowelBalance == 0;
    }
}
