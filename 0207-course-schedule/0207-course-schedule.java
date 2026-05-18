class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //全部先修的關係結構
        List<Integer>[] adj = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++){
            adj[i] = new ArrayList<>();
        }
        for (int[] pre: prerequisites){
            adj[pre[1]].add(pre[0]);
        }

        // 紀錄狀態 0未拜訪 1當前路徑 2拜訪完成
        int[] visit = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, visit, adj)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course, int[] visit, List<Integer>[] adj){
        if (visit[course] == 1){
            return false;
        }
        if (visit[course] == 2){
            return true;
        }

        visit[course] = 1;
        // list裡面每個點都DFS
        for (int i : adj[course]){
            if (!dfs(i, visit, adj)) {
                return false;
            }
        }

        // 該點結束
        visit[course] = 2;
        return true;
    }
}