class Solution {
private:
    unordered_map<string,string> decode_table;

public:

    // Encodes a URL to a shortened URL.
    string encode(string longUrl) {
        hash<string> hash;
        auto longUrl_hash = hash(longUrl);
        stringstream ss;
        ss << longUrl_hash;
        string indexhash = ss.str();
        decode_table[indexHash] = longUrl;

        return indexHash;
    }

    // Decodes a shortened URL to its original URL.
    string decode(string shortUrl) {
        if(decode_table.count(shortUrl) == 0)
            return "";

        return decode_table[shortUrl];
    }
};

// Your Solution object will be instantiated and called as such:
// Solution solution;
// solution.decode(solution.encode(url));