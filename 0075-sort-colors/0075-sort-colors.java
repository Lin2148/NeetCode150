class Solution {
    public void sortColors(int[] nums) {
        // 0跟2要放的位置ptr
        int left = 0;
        int right = nums.length-1;

        int cur = 0;
        while (cur <= right){
            if (nums[cur] == 0){
                int tmp = nums[left];
                nums[left] = nums[cur];
                nums[cur] = tmp;

                cur++;
                left++;
            } else if (nums[cur] == 1){
                cur++;
            } else{
                int tmp = nums[right];
                nums[right] = nums[cur];
                nums[cur] = tmp;

                right--;
            }
        }
    }
}

        /*
        int[] arr = new int[3];
        for(int i : nums){
            arr[i]++;
        }
        for (int i = 0; i < nums.length; i++){
            if (i < arr[0]){
                nums[i] = 0;
            } else if (i < arr[0]+arr[1]){
                nums[i] = 1;
            } else{
                nums[i] = 2;
            }
        }
        */