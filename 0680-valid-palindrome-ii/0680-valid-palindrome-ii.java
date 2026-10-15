class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;

         while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return isPalin(s, left + 1, right)
                    || isPalin(s, left, right - 1);
            }
        }
        return true;
    }



    private boolean isPalin(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

/*
    private boolean checkValidPalin(String s, String pos){
        int left = 0;
        int right = s.length()-1;
        boolean flag = true;
        while(left < right){
            if (s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            } 
            else if (flag){
                if (pos.equals("left")) {
                    left++;
                } else {
                    right--;
                }
                flag = false;
            } else{
                return false;
            }
        }
        return true;
    }
*/
