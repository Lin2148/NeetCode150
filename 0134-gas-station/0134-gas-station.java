class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;   
        int curr = 0; 
        int start = 0; 

        for (int i = 0; i < gas.length; i++) {
            int net = gas[i] - cost[i];

            total += net;
            curr += net;

            if (curr < 0) {

                start = i + 1; 
                curr = 0;      
            }
        }
        return total >= 0 ? start : -1;
    }
}
