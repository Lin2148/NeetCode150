class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[k]; 

        for (int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        // min value heap (not key )
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for (int key : map.keySet()){
            minHeap.add(key);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        for (int i = 0; i < k; i++){
            ans[i] = minHeap.poll();
        }
        return ans;
    }
}