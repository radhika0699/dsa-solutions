class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for(int i = 1; i < nums.length; i++)
        {
            ans[i] = ans[i-1] * nums[i-1];
            // [1,1,2,6]
        }
        int prevSuff = 1;
        for(int i = nums.length-2;i>=0;i--)
        {
            prevSuff *= nums[i+1]; // prevSuff = 4*1, 4*3, 12*2
            ans[i]  *= prevSuff;   // ans[2] = 2*4, ans[1] = 12*1, ans[0] = 24*1  
        }
        return ans;
    }
}