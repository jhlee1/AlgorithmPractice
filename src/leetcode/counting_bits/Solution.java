package leetcode.counting_bits;

class Solution {

    // O (n)
    // Utilize the previous result
    public int[] countBitsInSinglePass(int n) {
        int[] result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            result[i] = result[i / 2] + i % 2;
        }

        return result;

    }

    // Simple way with O(n log n)
    public int[] countBits(int n) {
        int[] result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int tmp = i;
            int tmpResult = 0;
            while (tmp > 0) {
                if (tmp % 2 > 0) {
                    tmpResult++;
                }
                tmp /= 2;
            }

            result[i] = tmpResult;
        }

        return result;

    }
}
