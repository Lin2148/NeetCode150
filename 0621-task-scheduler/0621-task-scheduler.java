class Solution {
    public int leastInterval(char[] tasks, int n) {
        int ans = 0;
        int[] cnt = new int[26];
        for (char c : tasks){
            cnt[c-'A']++;
        }


        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : cnt){
            if (i > 0){
                pq.offer(i);
            }

        }

        while (!pq.isEmpty()){
            int cycle = n+1;
            List<Integer> tmp = new ArrayList<>();
            int taskCnt = 0;

            for (int i = 0; i < cycle; i++){
                if (!pq.isEmpty()){
                    int taskLeft = pq.poll();
                    taskLeft--;
                    taskCnt++;

                    if (taskLeft > 0){
                        tmp.add(taskLeft);
                    }
                }
            }
            for (int i : tmp){
                pq.offer(i);
            }

            if (pq.isEmpty()){
                ans += taskCnt;
            } else{
                ans += cycle;
            }
        }
        return ans;
    }
}