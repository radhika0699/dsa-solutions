/*

At each element x, we consider 3 possibilities:

Start fresh at x
Extend previous max: maxProdEndingHere * x
Extend previous min: minProdEndingHere * x

So:

New max = max(x, maxx, minx)
New min = min(x, maxx, minx)

*/

class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0], maxEndHere = nums[0], minEndHere = nums[0];
        for(int i = 1 ;i< nums.length;i++)
        {
            int x = nums[i];
            int temp = maxEndHere;
            maxEndHere = Math.max(x, Math.max(maxEndHere * x, minEndHere * x));
            System.out.println(maxEndHere + "" + i);
            minEndHere = Math.min(x, Math.min(temp * x, minEndHere * x));
            System.out.println(minEndHere + "" + i);

            maxProd = Math.max(maxProd, maxEndHere);
        }
        return maxProd;

    }

    
}