class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length())
            return "";
        Map<Character,Integer> hm = new HashMap<>();
        //count characters in t
        for(char c : t.toCharArray())
        {
            hm.put(c, hm.getOrDefault(c,0) + 1);
        }
        int targetRem = t.length();
        int[] minW = new int[]{0, Integer.MAX_VALUE};
        int st = 0;
        for(int end = 0; end  < s.length(); end++)
        {
            char ch = s.charAt(end);
            if(hm.containsKey(ch) && hm.get(ch) > 0)
            {
                targetRem--;
            }
            //Count character, even if not needed in t as it is part of window
            hm.put(ch, hm.getOrDefault(ch,0)-1);
            if(targetRem == 0) //window found
            {
                //check if window can be shrunk
                while(true)
                {
                    //check if window can be shrunk, keep removing extra characters until needed char is reached and then break;
                    char ch1 = s.charAt(st);
                    if(hm.get(ch1) == 0)
                        break; // ch1 is needed in t and so freq is zero and can't be removed
                    hm.put(ch1, hm.get(ch1) +1); // add back to the map
                    st++;
                }
                //get window length
                if(end - st < minW[1] - minW[0])
                {
                    minW[1] = end;
                    minW[0] = st;
                }
                //put starting character back
                hm.put(s.charAt(st), hm.getOrDefault(s.charAt(st), 0) + 1);
                targetRem++;
                st++;
            }
        }
        return minW[1] >= s.length() ? "" : s.substring(minW[0],minW[1]+1);

    }
}