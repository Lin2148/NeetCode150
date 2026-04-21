class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // nlogn sorting
        Arrays.sort(nums); 
        List<List<Integer>> ans = new ArrayList<>();
        // n**2
        for (int i = 0; i < nums.length - 2; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int head = i + 1;
            int tail = nums.length - 1;

            while (head < tail) {
                if (nums[head] + nums[tail] == (-nums[i])){
                    ans.add(List.of(nums[i], nums[head], nums[tail]));
                    while (head < tail && nums[head] == nums[head + 1]) head++;
                    while (head < tail && nums[tail] == nums[tail - 1]) tail--;
                    head++;
                    tail--;
                }

                else if (nums[head] + nums[tail] < -nums[i]){
                    head++;
                }

                else if (nums[head] + nums[tail] > -nums[i]){
                    tail--;
                }
            }
        }
        return ans;
    }   
}