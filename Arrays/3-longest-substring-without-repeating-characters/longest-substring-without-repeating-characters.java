class Solution {
    public int lengthOfLongestSubstring(String s) {
        int st=0, res = 0;
        Map<Character, Integer> hm = new HashMap();
        for(int end=0;end<s.length();end++)
        {
            if(hm.containsKey(s.charAt(end)))
            {
                //Max of st and repeated character index  + 1
                // abcabcbb -> end  = 3; st = max(0,1) -> b, starts at b 
                st = Math.max(st, hm.get(s.charAt(end))+1);
            }
            //Max Length of substring
            res = Math.max(res, end-st+1);
            // Hash map - Character -> index
            hm.put(s.charAt(end), end);

        }
        return res;
    }
}