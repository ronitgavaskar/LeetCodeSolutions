/**
Write a function that reverses a string. The input string is given as an array of characters char[].

Ex:
["H", "a", "n"] => ["n", "a", "H"]

midIndex = 3/2 = 1
s[0] => s[2] = s[3 - 1 - (0)] 
s[1] => s[1]
s[2] => s[0]
*/

class ReverseString {
    public void reverseString(char[] s) {
        int midIndex = s.length/2;
        // essentially this will flip the array around the middle
        for (int i = 0; i < midIndex; i++) {
            char temp = s[s.length - 1 - i];
            s[s.length - 1 - i] = s[i];
            s[i] = temp;
        }
    }
}
