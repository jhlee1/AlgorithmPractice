package leetcode.unique_paths;

class Solution {
    final static int[][] memoization = new int[101][101];

    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        } else {
            final int firstCall = memoization[m - 1][n] == 0 ? uniquePaths(m - 1, n) : memoization[m - 1][n];
            final int secondCall = memoization[m][n - 1] == 0 ? uniquePaths(m, n - 1) : memoization[m][n - 1];
            final int result = firstCall + secondCall;

            memoization[m][n] = result;

            return result;
        }
    }

    public int iterativeUniquePaths(int m, int n) {
        for(int i = 1; i <= m; i++) {
            for( int j = 1; j <= n; j++) {
                memoization[i][j] = 1;
            }
        }

        for(int i = 2; i <= m; i++) {
            for( int j = 2; j <= n; j++) {
                memoization[i][j] = memoization[i-1][j] + memoization[i][j-1];
            }
        }

        return memoization[m][n];
    }
}

