class Solution {
    public boolean isHappy(int n) {
        // 2 ptr method less space
        // fast cal. 1 time first to get into loop
        int slowPtr = n;
        int fastPtr = cal(n);
        
        while (fastPtr != 1 && slowPtr != fastPtr){
            slowPtr = cal(slowPtr);
            fastPtr = cal(cal(fastPtr));
        }
        
        return (fastPtr == 1);
    }

    // cal ss
    private int cal(int n){

        int sum = 0;
        while (n > 0){
            int quotient = n % 10;
            sum += (quotient % 10) * (quotient % 10); 
            n /= 10;
        }
        return sum;
    }
}

/*
class Solution {
    public boolean isHappy(int n) {
        // save every time sum of square ans. to check loop
        HashSet<Integer> set = new HashSet<>();
        
        while (!set.contains(n)){
            // cal ss
            int sum = 0;
            int curr = n;
            while (curr > 0){
                int quotient = curr % 10;
                sum += (curr % 10) * (curr % 10); 
                curr /= 10;
            }
            if (sum == 1) return true;
            
            // not found next loop
            set.add(n);
            n = sum;
        }
    return false;
    }
}
*/