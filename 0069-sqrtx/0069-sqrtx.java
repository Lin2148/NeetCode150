class Solution {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }

        int min = 1;
        int max = x/2;

        // 紀錄floor的值 <才更新
        int ans = 1;

        // 停在min=max
        while (min<=max){
            int mid = min+ (max-min) /2;

            if (mid > x / mid){
                max = mid-1;
            } else {
                ans = mid;
                min = mid+1;
            } 
        }
        return ans;
    }
}