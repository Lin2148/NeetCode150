class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        // sort first
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for (int[] interval : intervals){
            if (ans.isEmpty()){
                ans.add(interval);
            }

            // compare with last interval in ans. need to merge
            else if (ans.get(ans.size() - 1)[1] >= interval[0] ){
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], interval[1]);
            }

            else {
                ans.add(interval);
            }
        }
        int[][] ansArr = ans.toArray(new int[0][]);
        return ansArr;
    }
}