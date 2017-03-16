class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        unordered_map<char,int> lettersMag;
        for(char c : magazine)
            lettersMag[c]++;
        for(char c : ransomNote)
            if(!lettersMag[c])
                return false;
            else
                lettersMag[c]--;

        return true;
    }
};
