class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        int div = columnNumber;
        int rem = 0;

        while (div > 0){
            div--;
            rem = div % 26;
            div /= 26;
            char c = (char) ('A'+rem);
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}