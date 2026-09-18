class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] ans = new int[n];
        int ansIdx = 0;
        
        
        int[][] tasksWithIdx = new int[n][3];
        for (int i = 0; i < n; i++){
            tasksWithIdx[i][0] = tasks[i][0];
            tasksWithIdx[i][1] = tasks[i][1];
            tasksWithIdx[i][2] = i;
        }
        // sort for enqueue into CPU 
        Arrays.sort(tasksWithIdx, (a,b)->Integer.compare(a[0],b[0]));


        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if (a[1] != b[1]){
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[2], b[2]);
        });


        long time = 0;
        int taskIdx = 0;
        while(ansIdx < n){
            // if no task, time jump to fastest exec job
            if (pq.isEmpty() && time < tasksWithIdx[taskIdx][0]){
                time = tasksWithIdx[taskIdx][0];
            }

            // enqueue
            while(taskIdx < n && tasksWithIdx[taskIdx][0] <= time){
                pq.offer(tasksWithIdx[taskIdx]);
                taskIdx++;
            }

            // poll
            int[] task = pq.poll();
            time += task[1];
            ans[ansIdx++] = task[2];
            //System.out.printf("[Loop] taskIdx=%d/%d, ansIdx=%d/%d, pqSize=%d, curTime=%d\n", taskIdx, n, ansIdx, n, pq.size(), time);
        }

        return ans;
    }
}