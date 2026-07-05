class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;


        
       

        
        while (left < right){
            //沒選轉
            if (nums[left] < nums[right]) {
                return nums[left];
            }

            //有選轉
            int mid = (left + (right-left) / 2);
            // 左邊遞增 找右半邊
            if (nums[mid] >= nums[left] ){
                left = mid+1;

            } else{  //在左半邊
                right = mid;
            }
        }
        return nums[left];
        

    }
}