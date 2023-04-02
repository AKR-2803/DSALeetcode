//Leetcode 29. Divide Two Integers
//https://leetcode.com/problems/divide-two-integers/

import java.math.BigInteger;
class Solution {
    public int divide(int dividend, int divisor) {
        BigInteger value = new BigInteger(String.valueOf(dividend)).divide(BigInteger.valueOf(divisor));
        int b = value.intValue();
        if (dividend == -2147483648 && divisor == -1) {
            return 2147483647;
        }
        return b;
    }
}
