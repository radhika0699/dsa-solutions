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
        boolean[][] dp = new boolean[n][n];
        int[] ans = new int[] { 0, 0 };

        for (int i = 0; i < n; i++) {
            //checking substring from i to i is always palin
            dp[i][i] = true;
        }

        
        for (int i = 0; i < n-1; i++) {
           //2 char palindrome
           if(s.charAt(i) == s.charAt(i+1))
            {
                dp[i][i+1] = true;
                ans[0] = i;
                ans[1] = i+1;
            }
        }

        for(int diff=2;diff<n;diff++)
        {
            //3 char palin to max
            for(int i = 0; i < n-diff;i++)
            {
                int j = i+ diff;
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1])
                {
                    dp[i][j] = true;
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return s.substring(ans[0],ans[1]+1);
    }

}