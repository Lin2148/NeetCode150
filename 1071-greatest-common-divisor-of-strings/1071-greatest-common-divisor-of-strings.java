class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int len1 = str1.length();
        int len2 = str2.length();

        int gcd = gcd(len1,len2);
        return str1.substring(0,gcd);
    }

    private int gcd(int i, int j){
        System.out.printf("i=%d, j=%d \n",i,j);
        return (j==0 ? i : gcd(j, i%j));
    }
}