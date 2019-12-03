/**
This solution would reverse the digits of an integer
*/

class ReverInteger {
    public int reverse(int x) {
        if (x == 0 || x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
            return 0;
        }
        
        String num = Integer.toString(x);
        
        // Note that we need to account for two things:
        // 1) if there's a - sign, then keep it there
        // 2) if last digit is 0 then it can be ignored
        // 3) if number is 0, return 0
        
        
        StringBuilder sb = new StringBuilder();
        // lets check if first character is -
        
        boolean isNegative = false;
        if (num.charAt(0) == '-') {
            isNegative = true;
        }
        
        //Check trailing 0s and find the index where it stops
        int validLastIndex = num.length() - 1;
        for (int i = validLastIndex; i >= 0; i--) {
            if(num.charAt(i) != '0') {
                validLastIndex = i;
                break;
            }
        }
        
        
        for (int i = validLastIndex; i >= 0; i--) {
            if(num.charAt(i) != '-') {
                sb.append(num.charAt(i));
            }
        }
        
        // now that stringbuilder has the number, just return the integer part of it
        
        long val = Long.parseLong(sb.toString());
        
        if (val > Integer.MAX_VALUE || val < Integer.MIN_VALUE) return 0;
        
        if (isNegative) {
            return (int)(0 - val);
        } else {
            return (int) val;
        }  
    }
}
