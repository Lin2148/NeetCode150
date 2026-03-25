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
        /*      bitmask solution
        n = ((n & 0xffff0000) >>> 16) | ((n & 0x0000ffff) << 16);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        return n;
        */