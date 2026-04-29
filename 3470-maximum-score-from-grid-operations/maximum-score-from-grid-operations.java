//Approach-3 (Most optimal)
//T.C : O(n^3)
//S.C : O(n^2)
class Solution {

    int n;
    long[][][] t;

    long solve(boolean prevTaken, int prevHeight, int col,
               int[][] grid, long[][] colPrefSum) {

        if (col == n) return 0;

        if (t[prevTaken ? 1 : 0][prevHeight][col] != -1)
            return t[prevTaken ? 1 : 0][prevHeight][col];

        long result = 0;

        for (int height = 0; height <= n; height++) {

            long prevColScore = 0;
            long currColScore = 0;

            if (!prevTaken && col > 0 && height > prevHeight) {
                prevColScore =
                    colPrefSum[height][col] - colPrefSum[prevHeight][col];
            }

            if (prevHeight > height) {
                currColScore =
                    colPrefSum[prevHeight][col + 1] - colPrefSum[height][col + 1];
            }

            long takeCurrent =
                currColScore + prevColScore +
                solve(true, height, col + 1, grid, colPrefSum);

            long skipCurrent =
                prevColScore +
                solve(false, height, col + 1, grid, colPrefSum);

            result = Math.max(result, Math.max(takeCurrent, skipCurrent));
        }

        return t[prevTaken ? 1 : 0][prevHeight][col] = result;
    }

    public long maximumScore(int[][] grid) {
        n = grid.length;

        t = new long[2][101][101];
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 101; j++)
                java.util.Arrays.fill(t[i][j], -1);

        long[][] colPrefSum = new long[n + 1][n + 1];

        for (int col = 1; col <= n; col++) {
            for (int row = 1; row <= n; row++) {
                colPrefSum[row][col] =
                    colPrefSum[row - 1][col] + grid[row - 1][col - 1];
            }
        }

        return solve(false, 0, 0, grid, colPrefSum);
    }
}