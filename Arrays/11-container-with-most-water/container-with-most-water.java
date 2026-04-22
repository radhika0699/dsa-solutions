class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length-1;
        int totWater = 0;
        while(i < j)
        {
            int currT = Math.min(height[i], height[j]) * (j-i);
            totWater = Math.max(totWater, currT);
            if(height[i] < height[j])
                i++;
            else
                j--;
        
       
        }
         return totWater;
    }
}

