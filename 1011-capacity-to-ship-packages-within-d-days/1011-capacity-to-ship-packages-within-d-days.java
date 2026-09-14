class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int minW= weights[0];
        int ans = 0;
        for (int i : weights){
            sum += i;
            if (i>minW){
                minW=i;
            }
        }
        minW = Math.max(minW,(sum+days-1)/days);
        int maxW = sum;
        
        System.out.printf("min=%d,  max=%d",minW,maxW);
        while (minW <= maxW){
            int mid = minW + (maxW-minW)/2;
            if(check(weights, days, mid)){
                ans = mid;
                maxW = mid-1;
            } else{
                // cant fit 
                minW = mid+1;
            }
            
        }
        return ans;
    }

    private boolean check(int[] weights, int days, int weight){
        int tmp = weight;
        int idx = 0;

        while (days > 0 && idx < weights.length){
            while (idx < weights.length && weights[idx] <= weight){
                weight -= weights[idx];
                idx++;
            }
            days--;
            weight = tmp;
        }
        return (idx == weights.length) ? true : false;
    }
}