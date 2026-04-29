class Solution {
    public int reverseBits(int n) {
        int res= 0;
        for(int i = 0; i < 32; i++)
        {
            
            res <<= 1; //make space for new bit
            res |= ((n >> i) & 1); //take LSB and check bit, keep shifting left

        }   
        return res;
    }
}