class Solution {
    //Brian Kernighan’s algorithm
    public int hammingWeight(int n) {
        int ct = 0;
        while(n != 0)
        {
            n = n & (n-1); 
            /*
            1. 10 -> 1010 -> 1010 & 1001 -> 1000 -> 8
            2. 8 -> 1000 & 0111 -> 0000
            */
            ct++; 
        }
        return ct;
    }

}