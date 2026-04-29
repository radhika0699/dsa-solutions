class Solution {
    public int characterReplacement(String s, int k) {
        
        int freq[] = new int[26];//track frequencies of characters
        int l = 0, maxFreq = 0, res = 0;
        for(int r = 0; r < s.length();r++)
        {
            freq[s.charAt(r) - 'A']++; //Add character to window
            maxFreq = Math.max(maxFreq, freq[s.charAt(r) - 'A']);
            if((r-l+1) -maxFreq > k)
            {//windowSize - maxSameChar > k , cant switch, shrink window
                freq[s.charAt(l) - 'A']--;
                l++;
            }   
            //Find max window size
            res=Math.max(res, r-l+1);
        }
        return res;
    }
}