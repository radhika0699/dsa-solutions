class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count =0;
        for (int i = 0; i < n; i++) {
            count += expand(i,i,s); //odd len
            count += expand(i,i+1,s); //even len  
        }
        return count;
    }
    private int expand(int left, int right, String s)
    {
        int ct = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
        {
            ct++;
            left--;
            right++;
        }
        return ct;
    }
}