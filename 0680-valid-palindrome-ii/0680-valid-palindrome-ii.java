class Solution {
    public boolean validPalindrome(String s) {
        return checkValidPalin(s, "left") || checkValidPalin(s, "right");
    }

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
}