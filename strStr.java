/**
Checks if needle exists within haystack and if it does, then returns the first possible index of needle. Else return -1

Test Case:
"hello", "ll" => 2

"aaaa", "bba" => -1

"mississippi", "sipp" => 6

More efficient solution would be indexOf() just wanted to write out my logic

*/
class strStr {
    
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;
        if (needle.isEmpty()) return 0;
        char firstNeedleChar = needle.charAt(0);
        int lengthNeedle = needle.length();
        char lastNeedleChar = needle.charAt(needle.length() - 1);
        
        // find all indices of firstChar
        ArrayList<Integer> indices = getIndices(firstNeedleChar, haystack);
        
        HashSet<Integer> narrowedIndices = narrowWithLength(indices, lastNeedleChar, lengthNeedle, haystack);
        
        if (narrowedIndices.isEmpty()) return -1;
        return getIndices(narrowedIndices, haystack, needle);
    }
    
    public ArrayList<Integer> getIndices(char first, String s) {
        ArrayList<Integer> startingIndicesList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == first) {
                startingIndicesList.add(i);
            }
        }
        return startingIndicesList;
    }
    
    public HashSet<Integer> narrowWithLength(ArrayList<Integer> indices, char lastNeedleChar, int lengthNeedle, String hay) {
        HashSet<Integer> ret = new HashSet<Integer>();
        
        for(int ind: indices) {
            if (ind + lengthNeedle - 1 < hay.length()) {
                if (hay.charAt(ind + lengthNeedle - 1) == lastNeedleChar) {
                    ret.add(ind);
                }
            }
        }
        return ret;
    }
    
    public int getIndices(HashSet<Integer> indices, String hay, String needle) {
        // index within indices will start at 0 in needle
        
        boolean isValid = true;
        for (int start: indices) {
            isValid = true;
            for (int i = 0; i < needle.length(); i++) {
                if (needle.charAt(i) != hay.charAt(start + i)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                return start;
            }
        }
        
        return -1;
    }
}
