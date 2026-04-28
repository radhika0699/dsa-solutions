class Solution {
    public int missingNumber(int[] nums) {     
        /*
        011
        000
        001
        ---
        010
        */
        int res = 0;
        //create xor of range -> 0 to n
        for(int i = 0; i<= nums.length; i++)
            res ^= i;
        for(int i = 0; i< nums.length; i++)
            res ^= nums[i];
        return res;
    }
}
