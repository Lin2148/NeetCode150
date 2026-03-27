class Solution {
    public boolean isHappy(int n) {
        // save every time sum of square ans. to check loop
        HashMap<Integer, Integer> map = new HashMap<>();
        
        while (!map.containsKey(n)){
            // cal ss
            int sum = 0;
            int remain = n;
            while (remain > 0){
                sum += Math.pow((remain % 10),2); 
                remain = (remain / 10);
            }
            if (sum == 1) return true;
            
            // not found next loop
            map.put(n,sum);
            n = sum;
        }
    return false;
    }
}