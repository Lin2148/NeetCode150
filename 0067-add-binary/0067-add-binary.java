//tuple 可以用ascii相減得到數字  eg '1'-'0'=1， '0'-'0'=0

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry=0;
        while(i>=0 || j>=0 || carry==1){
            int da = (i>=0 && a.charAt(i)=='1') ? 1:0;
            int db = (j>=0 && b.charAt(j)=='1') ? 1:0;

            int sum=da+db+carry;
            int digit=sum%2;
            carry=sum/2;
            sb.append(digit);
            i--;
            j--;
        }
    return sb.reverse().toString();
    }
}