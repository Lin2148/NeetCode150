class Solution {
    public double myPow(double x, int n) {
        if (n == 0){
            return 1.0;
        }

        long ln = n;

        //負號
        if (ln < 0) {
            x = 1 / x;
            ln = -ln;
        }
        return pow(x, ln);
    }

    private double pow(double x, long n){
        if (n == 0){
            return 1.0;
        }

        double half = pow(x, n / 2);

        if (n % 2 == 0) {
            //偶數
            return half * half;
        } else {
            //奇數
            return half * half * x;
        }
        
    }
        
    
}