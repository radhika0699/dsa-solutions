class Solution {
    //Approach 1: Convert to string, 2 pointers
    //Approach 2: reverse number, check if numbers are same
    public boolean isPalindrome(int x) {
        int y = 0, t = x;

        while(t>0)
        {
            int r = t%10;
            y=y*10+r;
            t/=10;
        }
        return x == y? true : false;
    }
}