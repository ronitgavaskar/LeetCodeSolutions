// Essentially we need to keep track of the number of zeroes encountered while iterating and shift by that many zeroes

// Keep in mind, if we havent encountered any 0, then dont replace with 0
// If we did then we want to maintain same number of 0s and would therefore replace current num by 0

class MoveZeroes {
    public void moveZeroes(int[] nums) {
        // Key to this is to keep track of zeroes before while iterating
        int numZer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // shift by number of zeroes
                nums[i - numZer] = nums[i];
                
                // if you know theres atleast 1 zero
                if (numZer > 0) {
                    nums[i] = 0;
                }
            } else {
                numZer++;
            }
        }
    }
}
