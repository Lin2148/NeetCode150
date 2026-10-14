class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0){
            return 0;
        }

        Map<Integer,Integer> hm = new HashMap<>();
        int ret = 1;

        for (int i : nums){
            if (hm.containsKey(i)) continue;

            //兩邊val = l+r+1
            if (hm.containsKey(i-1) && hm.containsKey(i+1)){
                int max = hm.get(i-1)+hm.get(i+1)+1;
                hm.put(i, max);
                
                // 同步最大值
                hm.put(i - hm.get(i - 1), max);
                hm.put(i + hm.get(i + 1), max);

                if (max > ret){
                    ret = max;
                }
            }
            //有一邊 val = onePart+1
            else if (hm.containsKey(i-1) || hm.containsKey(i+1)){
                int onePart = hm.containsKey(i - 1) ? hm.get(i - 1) : hm.get(i + 1);
                hm.put(i, onePart + 1);

                // 同步最大值
                if (hm.containsKey(i - 1)) {
                    hm.put(i - hm.get(i - 1), onePart + 1);
                } else {
                    hm.put(i + hm.get(i + 1), onePart + 1);
                }

                if (onePart + 1 > ret){
                    ret = onePart + 1;
                }
            }
            //都沒有
            else{
                hm.put(i, 1);
            }
        }
        return ret;
    }
}