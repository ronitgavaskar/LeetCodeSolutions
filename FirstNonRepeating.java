/**
This solution will use an array of 26 length to find first non-repeating character
*/
class FirstNonRepeating {
    public int firstUniqChar(String s) {
        // Keep an array of all the letters in the alphabet
        int[] countChar = new int[26];
        
        // Since we only have lower case letters, we can only keep 26 length
        for (int i = 0; i < s.length(); i++) {
            //ascii value - 97
            countChar[(int)s.charAt(i) - 97] += 1;
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (countChar[(int)s.charAt(i) - 97] == 1) {
                return i;
            }
        }
        
        return -1;
    }
}
