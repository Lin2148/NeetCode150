class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][];
        // max heap
        PriorityQueue<int[]> pq =  new PriorityQueue<>(
        (a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));

        for (int i = 0; i < k; i++){
            pq.offer(points[i]);
        }
        for (int i = k; i < points.length; i++){
            // 判斷更新
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            int farDist = pq.peek()[0] * pq.peek()[0] + pq.peek()[1] * pq.peek()[1];
            if (dist < farDist) {
                pq.poll();
                pq.offer(points[i]);
            }
        }

        /* 直接放，超過k再poll
        for (int[] p : points){
            pq.offer(p);
            if (pq.size() > k){
                pq.poll();
            }
        }
        */

        for (int i = 0; i<k; i++){
            ans[i] = pq.poll();
        }
        return ans;
    }
}