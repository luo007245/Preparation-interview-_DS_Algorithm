//Approach-1 (Early return)
//T.C : O(n log n)
//S.C : O(1)

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        // for(int asteroid : asteroids){
        //     if(mass < asteroid)
        //         return false;
        //         else if(mass >= 1e5)
        //             return true;

        //     mass += asteroid;
        // }
        // return true;


//Approach-1 (Simple sorting and greedy)
//T.C : O(n log n)
//S.C : O(1)
        long totalMass = mass;

        for(int  asteroid : asteroids){
             if(totalMass < asteroid)
                return false;

                totalMass += asteroid;
        }

            return true;
        
    }
}