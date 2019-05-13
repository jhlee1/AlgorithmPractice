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
}
