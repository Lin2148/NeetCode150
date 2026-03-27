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