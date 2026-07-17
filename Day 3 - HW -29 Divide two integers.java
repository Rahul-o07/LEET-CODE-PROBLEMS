class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Work with long to prevent overflow
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        int result = 0;

        // Core logic: subtract powers of 2 multiples of divisor
        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor;
            long multiple = 1;
            
            // Shift left until tempDivisor > absDividend
            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }
            
            absDividend -= tempDivisor;
            result += (int) multiple;
        }

        return negative ? -result : result;
    }
}
