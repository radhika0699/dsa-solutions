class Solution {
    //sliding window with dp: if outer chars are same and inner substr is palin, whole str is palin
    // Subarrays / substrings
    // Asked for:
    // Longest / shortest / count of valid subarray
    // Dynamically:
    // Expand right pointer
    // Shrink left pointer when condition breaks
    public String longestPalindrome(String s) {
        int n = s.length();
        int[] ans = new int[] { 0, 0 };
        for (int i = 0; i < n; i++) {
            //check max length for both odd len and even len palindromes at each index
            int oddLen = expand(i,i,s);
            if(oddLen > ans[1] - ans[0] + 1)
            {
                //distance from center to boundary of palin
                int dist = oddLen/2;
                ans[0] = i - dist;
                ans[1] = i + dist;
            }
            int evenLen = expand(i,i+1,s);
            if(evenLen > ans[1] - ans[0] + 1)
            {
               int dist = (evenLen/2) - 1;
                ans[0] = i - dist;
                ans[1] = i + dist + 1;
            }
        }
        return s.substring(ans[0],ans[1]+1);
    }
    private int expand(int i, int j, String s)
    {
        int left = i;
        int right = j;
        //expand from center
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
        {
            left--;
            right++;
        }
        return right-left-1; //right is one more than valid,left is one less than valid
        //includes 2 indices out of bounds, right - left + 1 - 2
    }
}