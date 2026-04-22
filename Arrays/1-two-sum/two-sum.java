class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> sum = new HashMap();
        for(int i = 0;i < nums.length; i++)
        {
            System.out.println(i);
            int rem = target - nums[i];
            if(sum.containsKey(rem))
                return new int[]{i, sum.get(rem)};
            sum.put(nums[i],i);
        }
        return null;
    }
}