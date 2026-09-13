class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int mod = k%len;
        if (mod == 0) return;

        int cnt = 0;
        for (int i = 0; cnt < len; i++){
            int curr = nums[i];
            int idx = i;
            do{
                int next = (idx+k) % len;

                int tmp = nums[next];
                nums[next] = curr;
                curr = tmp;
                
                idx = next;
                cnt++;
            } while (idx != i);
        }
        return;
    }
}