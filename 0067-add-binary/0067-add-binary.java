class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;

        while(i >= 0 || j >= 0 || carry == 1){
            int da = (i>=0 && a.charAt(i)=='1') ? 1:0;
            int db = (j>=0 && b.charAt(j)=='1') ? 1:0;

            int digit = da^db^carry;
            carry = (da+db+carry)/2;
            sb.append(digit);
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}