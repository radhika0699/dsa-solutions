class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        List<String> res = new ArrayList<>();
        int[] ans = new int[] { 0, 0 };
        for (int i = 0; i < n; i++) {
            expand(i,i,s, res);
            
            expand(i,i+1,s,res);
           
        }
        return res.size();
    }
    private void expand(int i, int j, String s, List<String> res)
    {
        int left = i;
        int right = j;
        
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
        {
            res.add(s.substring(i,j+1));
            left--;
            right++;
        }
    }
}