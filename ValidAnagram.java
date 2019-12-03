/**
Checks if given two strings, they are anagrams of each other

Returns false if one string is longer than another

Uses simply one array of 26 length
*/
class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() > t.length() || s.length() < t.length()) return false;
        
        int[] charCount = new int[26];
        for (char c: s.toCharArray()) {
            charCount[(int) c - 97] += 1;
        }
        
        for (char c: t.toCharArray()) {
            charCount[(int) c - 97] -= 1;
        }
        
        for (int i = 0; i < 26; i++) {
            if (charCount[i] != 0) return false;
        }
        
        return true;
    }
}
