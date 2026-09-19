class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] graph = new int[n+1];

        for (int[] arr : trust){
            graph[arr[0]]--;
            graph[arr[1]]++;
        }

        for (int i = 1 ; i <= n; i++){
            if(graph[i] == n-1){
                return i;
            } 
        }
        return -1;
    }
}