// Given an array, rotate the array to the right by k steps, where k is non-negative.

//Ronits Thinking
// The biggest thing here is where i + k exceeds the bounds hence mod needs to be introduced. 

// This currently works and beats 53% of submissions but I will update this solution to be more efficient after couple days

class RotateArray {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] temp = new int[len];
        for (int i = 0; i < nums.length; i++) {
            temp[(i + k) % len] = nums[i];
        }
        for (int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
        }
    }
}
