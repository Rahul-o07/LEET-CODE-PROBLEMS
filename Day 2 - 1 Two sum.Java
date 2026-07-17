class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a map to store the number and its index
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // If the complement exists in the map, we found the pair
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            
            // Otherwise, add the current number and index to the map
            map.put(nums[i], i);
        }
        
        // Return an empty array if no solution is found (though the problem guarantees one)
        throw new IllegalArgumentException("No solution found");
    }
}
