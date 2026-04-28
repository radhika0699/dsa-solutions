class Solution {
    public int getSum(int a, int b) {
        while(b != 0)
        {
            int carry = (a&b) << 1;
            a = a^b;
            b = carry;
        }
        return a;
    }
}

/*
5 = 0101
3 = 0011

Sum (without carry):
0101 ^ 0011 = 0110  (6)
Carry:
0101 & 0011 = 0001
0001 << 1 = 0010  (2)

a = 6
b = 2

Step 2: Second iteration
Sum:
0110 ^ 0010 = 0100  (4)
Carry:
0110 & 0010 = 0010
0010 << 1 = 0100  (4)
Now:
a = 4
b = 4
*/