class Solution {
    public int reverseBits(int n) {
        int output=0;    
        for (int i = 0; i < 32; i++) {
            // move first
            output <<= 1; 
            output |= (n & 1);
            //logic right move
            n >>>= 1;  
        }
    return output;
    }
}