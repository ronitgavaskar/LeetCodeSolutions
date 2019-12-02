/**
Basically given an array representing a number, add 1;

Ronits thinking:
In this i need to divide it up and think of it in terms of different edge cases:

Test 1 (Basic):
123 -> 124

Test 2 (Intermediate):
129 -> 130

Test 3 (Advanced):
999 -> 1000

*/
class PlusOne {
    public int[] plusOne(int[] digits) {
        return addOneWithCarry(digits, digits.length - 1);
    }
    
    public int[] addOneWithCarry(int[] arr, int ind) {
        // if we dont need to extend length of array
        for (int i = ind; i >= 0; i--) {
            if (arr[i] != 9) {
                arr[i] += 1;
                arr = fillWithZeros(arr, i, arr.length);
                return arr;
            }
        }
        
        // if we do need to extend length of array then increase 
        int len = arr.length;
        arr = new int[len + 1];
        arr[0] = 1;
        arr = fillWithZeros(arr, 1, arr.length);
        return arr;
    }
    
    public int[] fillWithZeros(int[] arr, int start, int end) {
        for (int i = start + 1; i < end; i++) {
            arr[i] = 0;
        }
        return arr;
    }
}
