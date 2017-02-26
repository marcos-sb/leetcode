public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
    final List<Integer> anagrams = new ArrayList<>();
    if (s == null || p == null || s.isEmpty() || p.isEmpty() || s.length() < p.length())
      return anagrams;
    final Map<Character, Integer> countsP = new HashMap<>();
    for (int i = 0; i < p.length(); i++) {
      final Character c = p.charAt(i);
      if (!countsP.containsKey(c))
        countsP.put(c, 0);
      countsP.put(c, countsP.get(c) + 1);
    }
    final Map<Character, Integer> countsS = new HashMap<>();
    for(int i = 0; i < p.length(); i++) {
      final Character c = s.charAt(i);
      if(!countsS.containsKey(c))
        countsS.put(c, 0);
      countsS.put(c, countsS.get(c) + 1);
    }
    if(countsP.equals(countsS))
      anagrams.add(0);
    if(countsS.get(s.charAt(0)) == 1)
      countsS.remove(s.charAt(0));
    else
      countsS.put(s.charAt(0),countsS.get(s.charAt(0))-1);
    for(int i = p.length(); i<s.length(); i++) {
      final Character c = s.charAt(i);
      if(!countsS.containsKey(c))
        countsS.put(c,0);
      countsS.put(c,countsS.get(c)+1);
      if(countsP.equals(countsS))
        anagrams.add(i-p.length()+1);
      final Character f = s.charAt(i-p.length()+1);
      if(countsS.get(f) == 1)
        countsS.remove(f);
      else countsS.put(f,countsS.get(f)-1);
    }
    return anagrams;
  }
}
