class Solution {
    public int getSum(int a, int b) {
        while(b!=0){
            // compute carry and left shift 1 bit
            int carry = (a & b)<< 1; 
            //  XOR normal add(exclude carry)
            a = a ^ b;
            // if there is carry  next loop;
            b = carry;
        }
        return a;
        /*
        int carry = 0;
        int ans = 0;
        for (int i = 0; i < 32; i++){
            int tailA = (a>>i) & 1;
            int tailB = (b>>i) & 1;
            int sum = tailA ^ tailB ^ carry;

            ans |= (sum<<i);

            if ((tailA==1 && tailB==1)||(tailA==1 && carry==1)||(carry==1 && tailB==1)){
                carry = 1;
            } else{
                carry = 0;
            }
        }
        return ans;
        */
    }
}