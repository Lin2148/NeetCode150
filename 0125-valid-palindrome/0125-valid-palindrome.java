class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) return true;

        int first = 0;
        int last = s.length()-1; 
        while (first <last){
            char ptrfirst = s.charAt(first);
            char ptrlast = s.charAt(last);
            if (Character.isLetterOrDigit(ptrfirst)==false) first++;
            else if (Character.isLetterOrDigit(ptrlast)==false) last--;
            else {
                if (Character.toLowerCase(ptrfirst)!=Character.toLowerCase(ptrlast)){
                    return false;
                }
                first++;
                last--;
            }
        } 
        return true;
    }
}