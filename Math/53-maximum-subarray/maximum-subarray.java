/*
Kadane's Algo
The algorithm is based on dynamic programming. For each element in the array, it makes a choice: 
Extend: Add the current element to the maximum subarray sum ending at the previous position.
Restart: Start a new subarray beginning with the current element. 

*/

class Solution {
    public int maxSubArray(int[] nums) {
        int cSum = nums[0], maxSum = nums[0];
        for(int i = 1; i < nums.length;i++)
        {
            cSum = Math.max(cSum + nums[i], nums[i]); // extend or restart? 
            maxSum = Math.max(maxSum, cSum); 
        }
        return maxSum;
    }
}