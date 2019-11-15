// Given an array A of positive integers, let S be the sum of the digits of the minimal element of A. Return 0 if S is odd, 
// otherwise return 1.
import java.util.*;

public class SumOfDigitsInMinimumNumber {


    public int isSumOfMinNumberEven(int[] arr) {

        // Step 1: Get minimum of the array
        int minimum = getMinimumofArray(arr);

        // Step 2: How many digits are in minimum
        int len = Integer.toString(minimum).length();

        // Step 3: Add up the digits of the minimum number
        int sum = addDigits(minimum, len);

        // Step 4: return 1 if even or 0 if odd
        if (sum % 2 == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public int addDigits(int num, int len) {
        int sum = 0;
        for (int i = 0; i < len; i++) {
            double div = num / Math.pow(10, len - 1 - i);
            sum += div;
            num %= Math.pow(10, len - 1 - i);
        }
        return sum;
    }

    public int getMinimumofArray(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int num: arr) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }


    public static void main(String[] args) {
        SumOfDigitsInMinimumNumber s = new SumOfDigitsInMinimumNumber();
        int[] arr = new int[] {34,23,1,24,75,33,54,8};
        
        // Test Case 1: 
        // Should return 0 because minimum is 1 and since sum = 1;
        // since 1 is odd, should return 0

        System.out.println(s.isSumOfMinNumberEven(arr));


        // Test Case 2: 
        // Should return 1 because minimum is 33 and since sum = 1;
        // since 33 adds up to 6 which is even, should return 1

        arr = new int[] {99,77,33,66,55};
        System.out.println(s.isSumOfMinNumberEven(arr));

        


    }

}