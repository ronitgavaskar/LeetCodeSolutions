/* Replace every period (.) with [.] 

Tests:

"" => ""
"1.1.1.1" => 1[.]1[.]1[.]1


**/


class DefangleIP {
    public String defangIPaddr(String address) {
        if (address.isEmpty()) return "";
        
        StringBuilder sb = new StringBuilder();
        for(char c: address.toCharArray()) {
            if (c == '.') sb.append("[.]");
            else sb.append(c);
        }
        return sb.toString();
    }
    
    public static void main(String args[]) {
      DefangleIP s = new DefangleIP();
      System.out.println(s.defangIPaddr(""));
      System.out.println(s.defangIPaddr("1.1.1.1"));
    }
}
