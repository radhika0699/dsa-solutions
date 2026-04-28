class Solution {
    public int[] countBits(int n) {
        int[] a = new int[n+1];
        for(int i = 0; i<=n; i++)
        {
            a[i] = hammingWeight(i);
        }   
        return a;
    }
    private int hammingWeight(int n)
    {
        int ct = 0;
        while(n!=0)
        {
            n = n & (n-1);
            ct++;
        }
        return ct;
    }
}