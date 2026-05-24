//Approach- (Bottom-Up DP using Sorting)
//T.C : O(n*d)
//S.C : O(n)
class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        // t[i] = maximum jumps starting from index i
        int[] t = new int[n];
        Arrays.fill(t, 1);
        /* 
        In recursion + memoization:
        solve(i) depnds on smaller elements only.
        So in bottom-up, process samller values first.
        */

        int[][] vec = new int[n][2];
        for(int i = 0; i < n; i++){
            vec[i][0] = arr[i];
            vec[i][1] = i;
        }

        Arrays.sort(vec, (a, b) -> a[0] - b[0]);

        for(int[] it: vec){
            int i = it[1];

            // move left
            for(int j = i - 1; j >= Math.max(0, i -d); j--){
                // same breaking condition

                if(arr[j] >= arr[i])
                break;
                t[i] = Math.max(t[i], 1 +t[j]);
            }

            // move right
            for(int j = i + 1; j <= Math.min(n -1, i + d); j++){
                // same breaking condition 
                if(arr[j] >= arr[i])
                 break;
                 t[i] = Math.max(t[i], 1 +t[j]);
            }
        }
        return Arrays.stream(t).max().getAsInt();
    }
}