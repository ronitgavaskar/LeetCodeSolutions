/**
Given an array and a target, see if two numbers within the array add up to the target.

Return indices of said two elements if present;
*/
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // one thing to take care of here:
        // we dont care about duplicates 
        // return indices 
        
        // create a hashset of nums
        HashSet<Integer> numSet = new HashSet<>();
        for (int num: nums) {
            numSet.add(num);
        }
        
        // Now check if target - number in numSet exists within numSet
        
        boolean containsTwoSum = false;
        int first = 0;
        int second = 0;
        for (int num: numSet) {
            if (numSet.contains(target - num)) {
                containsTwoSum = true;
                first = num;
                second = target - num;
                break;
            }
        }
        
        // iterate through and find indices of the above twoSum
        int[] ret = new int[2];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == first || nums[i] == second) {
                ret[count] = i;
                count++;
            }
            if (count == 2) break;
        }
        
        return ret;
    }
}
