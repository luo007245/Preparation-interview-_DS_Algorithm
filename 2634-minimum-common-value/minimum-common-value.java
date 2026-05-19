class Solution {
        // Approach-1 (using Set)
        // T.C : O(m+n)
        // S.C  : O(m)
        // Set<Integer> set = new HashSet<>();
        // for (int num : nums1) {
        //     set.add(num);
        // }

        // for (int num : nums2) {
        //     if (set.contains(num)) {
        //         return num;
        //     }
        // }

        // return -1;


        // Approach-1 (using Binary search)
        // T.C : O(m+n)
        // S.C : O(m)
        public boolean binarySearch(int[] nums, int target){

        int l = 0, r = nums.length -1;

        while(l <= r){
            int mid = l + (r-l)/2;

            if(nums[mid] == target){
                return true;
            } else if (nums[mid] < target){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;
    }

    public int getCommon(int[] nums1, int[] nums2) {
        for(int num : nums1){
             if (binarySearch(nums2, num)) {
                return num;
            }
        }

        return -1;

    
    }
}