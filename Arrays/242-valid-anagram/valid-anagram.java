class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> hm = new HashMap();
        if(s.length() != t.length())
            return false;
        for(char c : s.toCharArray())
            hm.put(c, hm.getOrDefault(c,0) + 1);
        for(char ch : t.toCharArray())
        {
            if(!hm.containsKey(ch) || hm.get(ch) <= 0)
                return false;
            hm.put(ch, hm.get(ch) - 1);
        }
        return true;
    }
}