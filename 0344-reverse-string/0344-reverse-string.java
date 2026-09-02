class Solution {
    public void reverseString(char[] s) {
        char tmp;
        int idx = s.length-1;
        for (int i = 0; i < s.length/2; i++){
            tmp = s[idx];
            s[idx] = s[i];
            s[i] = tmp;
            idx--; 
        }

    }
}