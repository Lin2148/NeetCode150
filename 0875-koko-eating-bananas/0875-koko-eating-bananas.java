class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // 建立b search arr 從1~piles最大數 (最差解吃最快每個arr花一小時)
        int maxVal = Arrays.stream(piles).max().getAsInt();
        int left = 1, right = maxVal;

        while (left < right) {
            int mid = left + (right - left) / 2; 
            int k = calK(piles, mid);
            // legal eating k
            if (k <= h){
                right = mid;
            } else{
                left = mid + 1;
            }
        }
    return left;
    }

    private int calK(int[] piles, int speed) {
        int k = 0;
        for (int pile : piles) {

            k += (pile - 1) / speed + 1;
        }
        return k;
    }
}