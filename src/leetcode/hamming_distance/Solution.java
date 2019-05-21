package leetcode.hamming_distance;

public class Solution {
    public int hammingDistance(int x, int y) {
        int result = 0;
        char[] xBinary = Integer.toBinaryString(x).toCharArray();
        char[] yBinary = Integer.toBinaryString(y).toCharArray();
        int shift = xBinary.length - yBinary.length;

        if (shift > 0) {
            for (int i = 0; i < shift; i++) {
                if (xBinary[i] == '1') {
                    result++;
                }
            }

            for (int i = 0; i < yBinary.length; i++) {
                if (yBinary[i] != xBinary[i + shift]) {
                    result++;
                }
            }
        } else {
            shift = -shift;
            for (int i = 0; i < shift; i++) {
                if (yBinary[i] == '1') {
                    result++;
                }
            }

            for (int i = 0; i < xBinary.length; i++) {
                if (xBinary[i] != yBinary[i + shift]) {
                    result++;
                }
            }
        }

        return result;
    }

    public int hammingDistanceByBitOperation(int x, int y) {
//        x & y = 10 : if both bits are 1 then 1, else 0
//        x | y = 10 : if either bit is 1 then 1, else 0
//        x ^ y = 10 : if the bits are different then 1, else 0
//        a >> i : shift all bits to right for i times
//        a << i : shift all bits to left for i times
        int xor = x ^ y;
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result += (xor >> i) & 1;
        }

        return result;
    }
}
