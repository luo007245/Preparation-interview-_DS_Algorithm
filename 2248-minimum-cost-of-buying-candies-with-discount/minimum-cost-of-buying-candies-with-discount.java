//Approach-1 (Sorting + Greedy Skip Every 3rd)
//T.C : O(n log n)
//S.C : O(1)
class Solution {
    public int minimumCost(int[] cost) {
        int n = cost.length;
        Arrays.sort(cost);

    //Reverse the array to sort in decresing order
    for(int l = 0, r = n-1; l < r; l++, r--){

        int temp = cost[l];
        cost[l] = cost[r];
        cost[r] = temp;
       }
       int total = 0;
       
       for(int i = 0; i < n; i++)
            if(i %3 !=2){
                total += cost[i];
       }

       return total;
    }
}