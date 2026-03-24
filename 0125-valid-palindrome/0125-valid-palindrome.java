class Solution {
    public boolean isPalindrome(String s) {
        String nospaceLowerS = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int first = 0;
        int last = nospaceLowerS.length() - 1;

        while(first <= last){
            char sFirst = nospaceLowerS.charAt(first);
            char sLast = nospaceLowerS.charAt(last);

            if (sFirst == sLast){
                first++;
                last--;
            } else{
                return false;
            }
        }
        return true;
    }
}